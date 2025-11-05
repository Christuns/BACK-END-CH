package br.edu.unipaulista.backend.Blog.domainModel.repositories;


import br.edu.unipaulista.backend.Blog.domainModel.Profile;

import java.util.List;


public interface ProfileRepository {
    List<Profile> findAll();

    Profile findById(Long id);

    void deleteById(Long id);

    Profile save(Profile profile);
}
