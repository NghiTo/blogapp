package com.vti.blogapp.Service;

import com.vti.blogapp.Dto.PostDto;
import com.vti.blogapp.Form.PostCreateForm;
import com.vti.blogapp.Mapper.PostMapper;
import com.vti.blogapp.Repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService
{
    private final PostRepository postRepository;
    @Override
    public PostDto create(PostCreateForm form)
    {
        var post = PostMapper.map(form);
        var savePost = postRepository.save(post);
        return PostMapper.map(savePost);
    }
}
