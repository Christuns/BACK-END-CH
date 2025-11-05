package br.edu.unipaulista.backend.Blog.domainModel.repositories;

import br.edu.unipaulista.backend.Blog.domainModel.Tag;

import java.util.List;

public interface TagRepository {
    List<Tag> findAll();

    Tag findById(Long id);

    void deleteById(Long id);

    Tag save(Tag tag);
}
