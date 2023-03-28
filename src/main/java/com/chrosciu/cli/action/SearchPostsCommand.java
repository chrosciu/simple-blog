package com.chrosciu.cli.action;

import com.chrosciu.post.PostService;
import java.util.Scanner;

class SearchPostsCommand implements Command {
    @Override
    public void execute(PostService postService, Scanner scanner) {
        System.out.println("Enter query:");
        var query = scanner.nextLine();
        for (var shortPostDto : postService.searchPosts(query)) {
            System.out.println(shortPostDto.format());
        }
    }
}
