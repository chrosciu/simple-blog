package com.chrosciu.cli.action;

import com.chrosciu.post.service.PostService;
import java.util.Scanner;

public class ShowPostsTitlesAction implements Action {
    @Override
    public void execute(PostService postService, Scanner scanner) {
        for (var shortPostDto : postService.getAllPosts()) {
            System.out.println(shortPostDto.format());
        }
    }
}
