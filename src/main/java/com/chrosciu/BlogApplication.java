package com.chrosciu;

import com.chrosciu.cli.BlogCli;
import com.chrosciu.post.model.Post;
import com.chrosciu.post.service.PostService;
import java.util.ArrayList;
import java.util.Scanner;

public class BlogApplication {

    public static void main(String[] args) {
        var posts = new ArrayList<Post>();
        var postService = new PostService(posts);
        var scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        var blogCli = new BlogCli(postService, scanner);

        blogCli.run();
    }
}
