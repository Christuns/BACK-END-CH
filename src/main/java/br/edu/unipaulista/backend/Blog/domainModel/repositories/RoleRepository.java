package br.edu.unipaulista.backend.Blog.domainModel.repositories;

import br.edu.unipaulista.backend.Blog.domainModel.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> findAll();

    Role findById(Long id);

    void deleteById(Long id);

    Role save(Role role);
}
