package br.edu.unipaulista.backend.Blog.Service;

import br.edu.unipaulista.backend.Blog.domainModel.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> findAll();

    Post findById(UUID id);

    void deleteById(UUID id);

    Post create(Post post);

    Post update(Post post);

    Post partialUpdate(Post post);
}
