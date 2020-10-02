package pl.adriangora.monitor.infrastructure;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.adriangora.monitor.PullRequestInfo;

@Component
public class GithubClient {

    private final static String MEDIA_TYPE = "application/vnd.github.v3+json";
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public GithubClient(RestTemplate restTemplate,
                        @Value("${github.baseUrl}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public RepositoryPullRequestDto[] getOpenPullRequests(String owner, String repository) {
        String url = baseUrl + "/repos/" + owner + "/" + repository + "/pulls";
        return restTemplate.getForObject(url, RepositoryPullRequestDto[].class, Map.of("state", "open"));
    }

    public RepositoryDto[] getRepositories(String owner) {
        String url = baseUrl + "/users/" + owner  + "/repos";
        return restTemplate.getForObject(url, RepositoryDto[].class);
    }
}
