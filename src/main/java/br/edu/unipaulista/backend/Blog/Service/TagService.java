package br.edu.unipaulista.backend.Blog.Service;

import br.edu.unipaulista.backend.Blog.domainModel.Tag;

import java.util.List;

public interface TagService {
    public List<Tag> findAll();

    Tag findById(Long id);

    void deleteById(Long id);

    Tag create(Tag tag);

    Tag update(Tag tag);

    Tag partialUpdate(Tag tag);
}
