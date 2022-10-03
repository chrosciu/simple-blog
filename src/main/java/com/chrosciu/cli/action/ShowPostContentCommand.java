package com.chrosciu.cli.action;

import com.chrosciu.post.service.PostService;
import java.util.Scanner;

class ShowPostContentCommand implements Command {
    @Override
    public void execute(PostService postService, Scanner scanner) {
        System.out.println("Enter post id:");
        var line = scanner.nextLine();
        var postId = Integer.parseInt(line);
        var postContentDto = postService.getPost(postId);
        postContentDto.ifPresentOrElse(
            dto -> System.out.println(dto.getContent()),
            () -> System.out.println("No post found with given id"));
    }
}
