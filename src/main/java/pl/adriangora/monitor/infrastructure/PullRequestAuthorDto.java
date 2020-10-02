package pl.adriangora.monitor.infrastructure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestAuthorDto {
    private final String login;
    private final String avatarUrl;

    @JsonCreator
    public PullRequestAuthorDto(@JsonProperty("login") String login,
                                @JsonProperty("avatar_url") String avatarUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
