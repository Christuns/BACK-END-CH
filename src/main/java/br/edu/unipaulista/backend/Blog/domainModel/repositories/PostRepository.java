package br.edu.unipaulista.backend.Blog.domainModel.repositories;

import br.edu.unipaulista.backend.Blog.domainModel.Post;

import java.util.List;
import java.util.UUID;

public interface PostRepository {
    List<Post> findAll();

    Post findById(UUID id);

    void deleteById(UUID id);

    Post save(Post post);
}
