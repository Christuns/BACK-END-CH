package br.edu.unipaulista.backend.Blog.Service;

import br.edu.unipaulista.backend.Blog.domainModel.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> findAll();

    User findById(UUID id);

    void deleteById(UUID id);

    User create(User user);

    User update(User user);

    User partialUpdate(User user);
}
