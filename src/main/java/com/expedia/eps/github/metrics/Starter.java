package com.expedia.eps.github.metrics;

import static com.expedia.eps.github.metrics.support.Repository.NotificationService;
import static java.time.Duration.between;
import static java.time.OffsetDateTime.now;
import static java.time.OffsetDateTime.parse;

import com.expedia.eps.github.metrics.models.PullRequest;
import com.expedia.eps.github.metrics.services.GithubService;

import java.util.List;

public class Starter {

    public static void main(String[] args) {
        final GithubService githubService = new GithubService();

//        Arrays.stream(Repository.values())
//                .forEach(System.out::println);

        final List<PullRequest> pullRequests = githubService.getClosedPullRequests(NotificationService);

        pullRequests.stream()
                .filter(pull -> parse(pull.createdAt).isAfter(now().minusWeeks(3)))
                .forEach(pull -> System.out.println("Closed: " + parse(pull.closedAt).toString() + "  Created: " + parse(pull.createdAt).toString() + "  Duration: " + between(parse(pull.createdAt), parse(pull.closedAt)).toString()));
//                .peek(pull -> System.out.println("Closed: " + parse(pull.closedAt).toString() + "  -  Created: " + parse(pull.createdAt).toString() + "  Duration: " + between(parse(pull.createdAt), parse(pull.closedAt)).toString()))
//                .map(pull -> between(parse(pull.createdAt), parse(pull.closedAt)))
//                .forEach(System.out::println);
    }
}
