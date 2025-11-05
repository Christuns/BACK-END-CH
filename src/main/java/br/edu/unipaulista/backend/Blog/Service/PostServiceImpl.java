package br.edu.unipaulista.backend.Blog.Service;

import br.edu.unipaulista.backend.Blog.domainModel.Post;
import br.edu.unipaulista.backend.Blog.domainModel.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    @Override
    public List<Post> findAll(){
        return this.repository.findAll();
    }

    @Override
    public Post findById(UUID id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id){
       this.repository.deleteById(id);
    }

    @Override
    public Post create(Post post){

        return  this.repository.save(post);
    }

    @Override
    public Post update(Post post) {
        return this.repository.save(post);
    }

    @Override
    public Post partialUpdate(Post post){
        return this.repository.save(post);
    }
}
