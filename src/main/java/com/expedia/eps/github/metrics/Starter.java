package com.expedia.eps.github.metrics;

import static java.time.Duration.between;
import static java.time.OffsetDateTime.now;
import static java.time.OffsetDateTime.parse;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import com.expedia.eps.github.metrics.services.GithubService;
import com.expedia.eps.github.metrics.support.Repository;

import java.util.List;

public class Starter {

    public static void main(String[] args) {
        final GithubService githubService = new GithubService();

        stream(Repository.values())
                .map(githubService::getClosedPullRequests)
                .flatMap(List::stream)
                .filter(pull -> parse(pull.createdAt).isAfter(now().minusWeeks(5)))
                .collect(toList())
                .forEach(pull -> System.out.println("Closed: " + rightPadding(parse(pull.closedAt).toString(), 22) + "Created: " + parse(pull.createdAt).toString() + "  Duration: " + rightPadding(between(parse(pull.createdAt), parse(pull.closedAt)).toString().replace("PT", ""), 10) + "\t  #" + pull.number + "\t  Repo: " + pull.head.repo.name));
//                .forEach(pull -> System.out.println(pull.head.repo.name));

//        final List<PullRequest> pullRequests = githubService.getClosedPullRequests(NotificationService);

//        pullRequests.stream()
//                .filter(pull -> parse(pull.createdAt).isAfter(now().minusWeeks(3)))
//                .forEach(pull -> System.out.println("Repo: " + pull.head.repo.name + "Closed: " + parse(pull.closedAt).toString() + "  Created: " + parse(pull.createdAt).toString() + "  Duration: " + between(parse(pull.createdAt), parse(pull.closedAt)).toString()));
//                .peek(pull -> System.out.println("Closed: " + parse(pull.closedAt).toString() + "  -  Created: " + parse(pull.createdAt).toString() + "  Duration: " + between(parse(pull.createdAt), parse(pull.closedAt)).toString()))
//                .map(pull -> between(parse(pull.createdAt), parse(pull.closedAt)))
//                .forEach(System.out::println);
    }

    private static String rightPadding(String str, int num) {
        return String.format("%1$-" + num + "s", str);
    }
}
