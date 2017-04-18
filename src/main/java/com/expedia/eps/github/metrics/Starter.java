package com.expedia.eps.github.metrics;

import com.expedia.eps.github.connectors.GithubApi;
import com.expedia.eps.github.metrics.models.PullRequest;

import java.util.List;

import feign.Feign;
import feign.jackson.JacksonDecoder;

public class Starter {

    public static void main(String... args) {

        final GithubApi githubApi = Feign.builder()
                .decoder(new JacksonDecoder())
                .target(GithubApi.class, "https://ewegithub.sb.karmalab.net/api/v3");

        final List<PullRequest> pullRequests = githubApi.getPullRequests("EWE", "eps-booking-notification-service", "closed");

        pullRequests.forEach(System.out::println);
    }
}
