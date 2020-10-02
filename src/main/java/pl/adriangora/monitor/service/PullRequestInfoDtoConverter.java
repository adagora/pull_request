package pl.adriangora.monitor.service;

import java.time.Duration;
import org.springframework.stereotype.Component;
import pl.adriangora.monitor.NowProvider;
import pl.adriangora.monitor.PullRequestInfo;
import pl.adriangora.monitor.infrastructure.RepositoryPullRequestDto;

@Component
public class PullRequestInfoDtoConverter {
    private final NowProvider nowProvider;

    public PullRequestInfoDtoConverter(NowProvider nowProvider) {
        this.nowProvider = nowProvider;
    }

    PullRequestInfo toPullRequestInfo(RepositoryPullRequestDto pullRequestDto) {
        long age = Duration.between(pullRequestDto.getCreatedAt(), nowProvider.now()).toDays();
        return new PullRequestInfo(pullRequestDto.getId(),
                age,
                pullRequestDto.getUser().getLogin(),
                pullRequestDto.getUser().getAvatarUrl(),
                pullRequestDto.getState());
    }
}
