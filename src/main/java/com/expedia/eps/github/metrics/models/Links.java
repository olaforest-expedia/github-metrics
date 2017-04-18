package com.expedia.eps.github.metrics.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "html",
    "issue",
    "comments",
    "review_comments",
    "review_comment",
    "commits",
    "statuses"
})
public class Links {

    @JsonProperty("self")
    public Self self;
    @JsonProperty("html")
    public Html html;
    @JsonProperty("issue")
    public Issue issue;
    @JsonProperty("comments")
    public Comments comments;
    @JsonProperty("review_comments")
    public ReviewComments reviewComments;
    @JsonProperty("review_comment")
    public ReviewComment reviewComment;
    @JsonProperty("commits")
    public Commits commits;
    @JsonProperty("statuses")
    public Statuses statuses;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
