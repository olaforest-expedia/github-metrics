package com.expedia.eps.github.metrics;

import static com.expedia.eps.github.metrics.support.Repository.NotificationService;

import com.expedia.eps.github.metrics.models.PullRequest;
import com.expedia.eps.github.metrics.services.GithubService;

import java.util.List;

public class Starter {

    public static void main(String[] args) {
        final GithubService githubService = new GithubService();

        final List<PullRequest> pullRequests = githubService.getPullRequests(NotificationService, "closed");

        pullRequests.forEach(System.out::println);
    }
}
