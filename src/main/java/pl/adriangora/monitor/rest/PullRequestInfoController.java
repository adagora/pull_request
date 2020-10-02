package pl.adriangora.monitor.rest;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.adriangora.monitor.PullRequestInfo;
import pl.adriangora.monitor.service.PullRequestInfoService;

@RestController
public class PullRequestInfoController {

    private final PullRequestInfoService pullRequestInfoService;

    public PullRequestInfoController(PullRequestInfoService pullRequestInfoService) {
        this.pullRequestInfoService = pullRequestInfoService;
    }

    @GetMapping("/pull-requests/{owner}/{repository}")
    List<PullRequestInfo> getPullRequests(@PathVariable("owner") String owner, @PathVariable("repository") String repository) {
        return pullRequestInfoService.getPullRequestsInfo(owner, repository);
    }
}
