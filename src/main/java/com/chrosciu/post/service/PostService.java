package com.chrosciu.post.service;

import com.chrosciu.post.exception.PostException;
import com.chrosciu.post.model.Post;
import com.chrosciu.post.transfer.NewPostDto;
import com.chrosciu.post.transfer.PostContentDto;
import com.chrosciu.post.transfer.ShortPostDto;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostService {
    private final List<Post> posts;

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

    public PostContentDto getPost(int postId) {
        return posts.stream()
            .filter(post -> postId == post.getId())
            .map(post -> new PostContentDto(post.getContent()))
            .findFirst()
            .orElseThrow(() -> new PostException("Post with given id is not found"));
    }

    public int addPost(NewPostDto newPostDto) {
        if (newPostDto.getTitle().length() > 20) {
            throw new PostException("Title is too long! (may be up to 20 characters)");
        }
        int maxId = posts.stream().mapToInt(Post::getId).max().orElse(-1);
        int newId = maxId + 1;
        posts.add(new Post(newId, newPostDto.getTitle(), newPostDto.getContent()));
        return newId;
    }
}
