package com.expedia.eps.github.metrics.services;

import com.expedia.eps.github.connectors.GithubApi;
import com.expedia.eps.github.metrics.models.PullRequest;
import com.expedia.eps.github.metrics.support.Repository;

import java.util.List;

import feign.Feign;
import feign.jackson.JacksonDecoder;

public class GithubService {
    private final GithubApi githubApi = Feign.builder()
            .decoder(new JacksonDecoder())
            .target(GithubApi.class, "https://ewegithub.sb.karmalab.net/api/v3");

    public List<PullRequest> getPullRequests(Repository repo, String state) {
        return githubApi.getPullRequests(repo.owner(), repo.name(), state);
    }
}
