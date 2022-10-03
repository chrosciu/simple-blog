package com.chrosciu.cli.action;

import com.chrosciu.post.service.PostService;
import java.util.Scanner;

public interface Command {
    void execute(PostService postService, Scanner scanner);
}
