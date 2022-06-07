package com.chrosciu.cli;

import com.chrosciu.cli.action.Action;
import com.chrosciu.cli.action.AddPostAction;
import com.chrosciu.cli.action.ExitApplicationAction;
import com.chrosciu.cli.action.NoOpAction;
import com.chrosciu.cli.action.SearchPostsAction;
import com.chrosciu.cli.action.ShowPostContentAction;
import com.chrosciu.cli.action.ShowPostsTitlesAction;
import com.chrosciu.post.service.PostService;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BlogCli {
    private final PostService postService;
    private final Scanner scanner;

    private static final Action SHOW_POSTS_TITLES_ACTION = new ShowPostsTitlesAction();
    private static final Action SEARCH_POSTS_ACTION = new SearchPostsAction();
    private static final Action SHOW_POST_CONTENT_ACTION = new ShowPostContentAction();
    private static final Action ADD_POST_ACTION = new AddPostAction();
    private static final Action EXIT_APPLICATION_ACTION = new ExitApplicationAction();
    private static final Action NO_OP_ACTION = new NoOpAction();

    public void run() {
        System.out.println("*** Welcome to Blog application ***");
        for (;;) {
            System.out.println("Available actions");
            System.out.println("1 - Show posts titles");
            System.out.println("2 - Search posts");
            System.out.println("3 - Show post content");
            System.out.println("4 - Add post");
            System.out.println("0 - Exit application");
            System.out.println("Choose action:");
            try {
                var option = scanner.nextInt();
                var action = switch (option) {
                    case 1 -> SHOW_POSTS_TITLES_ACTION;
                    case 2 -> SEARCH_POSTS_ACTION;
                    case 3 -> SHOW_POST_CONTENT_ACTION;
                    case 4 -> ADD_POST_ACTION;
                    case 0 -> EXIT_APPLICATION_ACTION;
                    default -> NO_OP_ACTION;
                };
                action.execute(postService, scanner);
                if (action.shouldTerminate()) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    }
}
