package com.chrosciu.cli.action;

import com.chrosciu.post.service.PostService;
import java.util.Scanner;

public class ShowPostContentAction implements Action {
    @Override
    public void execute(PostService postService, Scanner scanner) {
        System.out.println("Enter post id:");
        var postId = scanner.nextInt();
        var postContentDto = postService.getPost(postId);
        System.out.println(postContentDto.getContent());
    }
}
