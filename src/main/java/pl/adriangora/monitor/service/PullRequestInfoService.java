package pl.adriangora.monitor.service;

import java.util.List;
import org.springframework.stereotype.Component;
import pl.adriangora.monitor.PullRequestInfo;
import pl.adriangora.monitor.infrastructure.GithubClient;
import pl.adriangora.monitor.infrastructure.RepositoryPullRequestDto;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Component
public class PullRequestInfoService {

    private final GithubClient githubClient;
    private final PullRequestInfoDtoConverter dtoConverter;

    public PullRequestInfoService(GithubClient githubClient, PullRequestInfoDtoConverter dtoConverter) {
        this.githubClient = githubClient;
        this.dtoConverter = dtoConverter;
    }

    public List<PullRequestInfo> getPullRequestsInfo(String owner, String repository) {
        RepositoryPullRequestDto[] openPullRequests = githubClient.getOpenPullRequests(owner, repository);
        return stream(openPullRequests)
                .map(dtoConverter::toPullRequestInfo)
                .collect(toList());
    }
}
