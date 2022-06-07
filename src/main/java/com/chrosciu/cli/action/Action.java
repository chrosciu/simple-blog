package com.chrosciu.cli.action;

import com.chrosciu.post.service.PostService;
import java.util.Scanner;

public interface Action {
    void execute(PostService postService, Scanner scanner);

    default boolean shouldTerminate() {
        return false;
    }
}
