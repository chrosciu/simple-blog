package com.chrosciu.post;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostService {
    private final List<Post> posts;
    private static int nextId = 0;

    public List<ShortPostDto> getAllPosts() {
        return posts.stream()
            .map(post -> new ShortPostDto(post.getId(), post.getTitle()))
            .toList();
    }

    public List<ShortPostDto> searchPosts(String query) {
        return posts.stream()
            .filter(post -> post.getTitle().contains(query) || post.getContent().contains(query))
            .map(post -> new ShortPostDto(post.getId(), post.getTitle()))
            .toList();
    }

    public Optional<PostContentDto> getPost(int postId) {
        return posts.stream()
            .filter(post -> postId == post.getId())
            .map(post -> new PostContentDto(post.getContent()))
            .findFirst();
    }

    public int addPost(NewPostDto newPostDto) {
        if (newPostDto.getTitle().length() > 20) {
            throw new PostException("Title is too long! (may be up to 20 characters)");
        }
        nextId = nextId + 1;
        posts.add(new Post(nextId, newPostDto.getTitle(), newPostDto.getContent()));
        return nextId;
    }
}
