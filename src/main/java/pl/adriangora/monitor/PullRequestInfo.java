package pl.adriangora.monitor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PullRequestInfo {
    private final long id;
    private final long age;
    private final String authorLogin;
    private final String authorAvatarUrl;
    private final String state;

    public PullRequestInfo(@JsonProperty("id") long id,
                           @JsonProperty("age") long age,
                           @JsonProperty("authorLogin") String authorLogin,
                           @JsonProperty("authorAvatarUrl") String authorAvatarUrl,
                           @JsonProperty("state") String state) {
        this.id = id;
        this.age = age;
        this.authorLogin = authorLogin;
        this.authorAvatarUrl = authorAvatarUrl;
        this.state = state;
    }

    public long getAge() {
        return age;
    }

    public String getAuthorLogin() {
        return authorLogin;
    }

    public String getAuthorAvatarUrl() {
        return authorAvatarUrl;
    }

    public String getState() {
        return state;
    }

    public long getId() {
        return id;
    }
}
