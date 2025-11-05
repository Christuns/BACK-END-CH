package br.edu.unipaulista.backend.Blog.Service;

import br.edu.unipaulista.backend.Blog.domainModel.Profile;
import br.edu.unipaulista.backend.Blog.domainModel.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    @Override
    public List<Profile> findAll(){
       return this.repository.findAll();
    }

    @Override
    public Profile findById(Long id){
       return this.repository.findById(id).orElse(null);


    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Profile create(Profile profile) {
        return this.repository.save(profile);
    }

    @Override
    public Profile update(Profile profile) {
        return this.repository.save(profile);
    }

    @Override
    public Profile partialUpdate(Profile profile) {
        return this.repository.save(profile);
    }
}
