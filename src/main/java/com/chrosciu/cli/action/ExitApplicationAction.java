package com.chrosciu.cli.action;

import com.chrosciu.post.service.PostService;
import java.util.Scanner;

public class ExitApplicationAction implements Action {
    @Override
    public void execute(PostService postService, Scanner scanner) {
        System.out.println("Thank you");
    }

    @Override
    public boolean shouldTerminate() {
        return true;
    }
}
