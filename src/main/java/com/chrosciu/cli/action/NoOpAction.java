package com.chrosciu.cli.action;

import com.chrosciu.post.service.PostService;
import java.util.Scanner;

public class NoOpAction implements Action {
    @Override
    public void execute(PostService postService, Scanner scanner) {
        //NO-OP
    }
}
