package com.chrosciu.cli.action;

import com.chrosciu.post.PostService;
import java.util.Scanner;

public interface Command {
    void execute(PostService postService, Scanner scanner);
}
