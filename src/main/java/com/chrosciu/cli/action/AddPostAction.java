package com.chrosciu.cli.action;

import com.chrosciu.post.service.PostService;
import com.chrosciu.post.transfer.NewPostDto;
import java.util.Scanner;

public class AddPostAction implements Action {
    @Override
    public void execute(PostService postService, Scanner scanner) {
        System.out.println("Enter post title:");
        var title = scanner.next();
        System.out.println("Enter post content:");
        var content = scanner.next();
        var newPostDto = new NewPostDto(title, content);
        var newPostId = postService.addPost(newPostDto);
        System.out.println("Added post with id: " + newPostId);
    }
}
