package pl.adriangora.monitor.infrastructure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryPullRequestDto {
    private final long id;
    private final PullRequestAuthorDto user;
    private final ZonedDateTime createdAt;
    private final String state;

    @JsonCreator
    public RepositoryPullRequestDto(@JsonProperty("id") long id,
                                    @JsonProperty("user") PullRequestAuthorDto user,
                                    @JsonProperty("created_at") ZonedDateTime createdAt,
                                    @JsonProperty("state") String state) {
        this.id = id;
        this.user = user;
        this.createdAt = createdAt;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public PullRequestAuthorDto getUser() {
        return user;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public String getState() {
        return state;
    }
}
