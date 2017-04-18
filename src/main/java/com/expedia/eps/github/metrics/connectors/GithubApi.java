package com.expedia.eps.github.metrics.connectors;

import com.expedia.eps.github.metrics.models.PullRequest;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Authorization: Basic b2xhZm9yZXN0OjBhYzUzOTVjYWMxZThmMTM1YTIwMmUzMTc0NTRiNTYyZDAwZDViYjA=", "Content-Type: application/json"})
public interface GithubApi {

    @RequestLine("GET /repos/{owner}/{repo}/pulls?state={state}")
    List<PullRequest> getPullRequests(@Param("owner") String owner, @Param("repo") String repo, @Param("state") String state);
}
