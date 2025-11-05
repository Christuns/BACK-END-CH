package br.edu.unipaulista.backend.Blog.Service;

import br.edu.unipaulista.backend.Blog.domainModel.Role;
import br.edu.unipaulista.backend.Blog.domainModel.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements  RoleService {

    private final RoleRepository repository;

    @Override
    public List<Role> findAll(){
        return this.repository.findAll();
    }
    @Override
    public Role findById(Long id){
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(Long id){
    this.repository.deleteById(id);
    }

    @Override
    public Role create(Role role){

        return this.repository.save(role);
    }

    @Override
    public Role partialUpdate(Role role) {
        return this.repository.save(role);
    }
}

