package com.chrosciu;

import com.chrosciu.cli.BlogCli;
import com.chrosciu.post.model.Post;
import com.chrosciu.post.service.PostService;
import com.chrosciu.post.transfer.NewPostDto;
import java.util.ArrayList;
import java.util.Scanner;

public class BlogApplication {

    public static void main(String[] args) {
        var posts = new ArrayList<Post>();
        var postService = new PostService(posts);
        var scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        var blogCli = new BlogCli(postService, scanner);

        postService.addPost(new NewPostDto(
            "Debugger sucks",
            "I cannot find any bug in my app, give me something better !")
        );
        postService.addPost(new NewPostDto(
            "Sneaky streams",
            "What really happens in this inferno ?")
        );

        blogCli.run();
    }
}