package br.edu.unipaulista.backend.Blog.domainModel.repositories;

import br.edu.unipaulista.backend.Blog.domainModel.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom<U, U1> {
    public Optional<User> findByIdWithProfileAndPostCriteria(java.util.UUID id);
    public List<User> findByMinRolesAndNameLikeCriteria(int minRoles, String name);
}
