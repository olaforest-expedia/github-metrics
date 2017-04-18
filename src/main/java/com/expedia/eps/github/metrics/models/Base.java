package com.expedia.eps.github.metrics.models;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(NON_NULL)
@JsonPropertyOrder({
        "label",
        "ref",
        "sha",
        "user",
        "repo"
})
public class Base {
    @JsonProperty("label")
    public String label;
    @JsonProperty("ref")
    public String ref;
    @JsonProperty("sha")
    public String sha;
    @JsonProperty("user")
    public User user;
    @JsonProperty("repo")
    public Repo repo;
}
