package com.chrosciu.cli.action;

import com.chrosciu.post.PostService;
import java.util.Scanner;

class NoOpCommand implements Command {
    @Override
    public void execute(PostService postService, Scanner scanner) {
        //NO-OP
    }
}
