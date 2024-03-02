package com.loginapp.service;

import com.loginapp.entity.Post;
import com.loginapp.payload.PostDto;
import com.loginapp.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost = postRepo.save(post);
        PostDto dto = mapToDto(savedPost);
        return dto;
    }
    PostDto mapToDto(Post savedPost){
        PostDto postDto = new PostDto();
        postDto.setId(savedPost.getId());
        postDto.setTitle(savedPost.getTitle());
        postDto.setDescription(savedPost.getDescription());
        postDto.setContent(savedPost.getContent());
        return postDto;
    }
    Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
