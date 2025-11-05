package br.edu.unipaulista.backend.Blog.Service;

import br.edu.unipaulista.backend.Blog.domainModel.Tag;
import br.edu.unipaulista.backend.Blog.domainModel.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository repository;


    @Override
    public List<Tag> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Tag findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
     this.repository.deleteById(id);
    }

    @Override
    public Tag create(Tag tag) {
        return this.repository.save(tag);
    }

    @Override
    public Tag update(Tag tag) {
        return this.repository.save(tag);
    }

    @Override
    public Tag partialUpdate(Tag tag) {
        return this.repository.save(tag);
    }
}
