package com.chrosciu.cli.action;

import com.chrosciu.post.PostService;
import java.util.Scanner;

class ExitApplicationCommand implements Command {
    @Override
    public void execute(PostService postService, Scanner scanner) {
        System.out.println("Thank you");
    }
}
