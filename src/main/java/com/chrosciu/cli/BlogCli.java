package com.chrosciu.cli;

import static com.chrosciu.cli.action.Action.NO_OP;

import com.chrosciu.cli.action.Action;
import com.chrosciu.post.PostService;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BlogCli {
    private final PostService postService;
    private final Scanner scanner;
    private final List<String> labels = Arrays.stream(Action.values())
        .filter(a -> a.getCode() != null)
        .map(a -> String.format("%d - %s", a.getCode(), a))
        .toList();

    public void run() {
        System.out.println("*** Welcome to Blog application ***");
        for (;;) {
            System.out.println("Available actions");
            for (var label: labels) {
                System.out.println(label);
            }
            System.out.println("Choose action:");
            try {
                var line = scanner.nextLine();
                var code = Integer.parseInt(line);
                var action = Arrays.stream(Action.values())
                    .filter(a -> code == a.getCode())
                    .findFirst()
                    .orElse(NO_OP);
                action.getCommand().execute(postService, scanner);
                if (action.isTerminal()) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
