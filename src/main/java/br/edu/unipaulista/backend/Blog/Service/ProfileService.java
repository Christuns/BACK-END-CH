package br.edu.unipaulista.backend.Blog.Service;

import br.edu.unipaulista.backend.Blog.domainModel.Profile;

import java.util.List;
import java.util.UUID;

public interface ProfileService {
    List<Profile> findAll();

    Profile findById(Long id);

    void deleteById(Long id);

    Profile create(Profile profile);

    Profile update(Profile profile);

    Profile partialUpdate(Profile profile);
}
