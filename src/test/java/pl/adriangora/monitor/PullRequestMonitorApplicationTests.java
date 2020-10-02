package pl.adriangora.monitor;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.adriangora.monitor.infrastructure.GithubClient;
import pl.adriangora.monitor.service.PullRequestInfoService;

@SpringBootTest
class PullRequestMonitorApplicationTests {

	@Autowired
	PullRequestInfoService pullRequestInfoService;

	@Test
	void shouldGetPullRequestsInfo() {

	}

}
