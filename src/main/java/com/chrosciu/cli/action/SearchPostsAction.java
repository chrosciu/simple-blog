package com.chrosciu.cli.action;

import com.chrosciu.post.service.PostService;
import java.util.Scanner;

public class SearchPostsAction implements Action {
    @Override
    public void execute(PostService postService, Scanner scanner) {
        System.out.println("Enter query:");
        var query = scanner.next();
        for (var shortPostDto : postService.searchPosts(query)) {
            System.out.println(shortPostDto.format());
        }
    }
}
