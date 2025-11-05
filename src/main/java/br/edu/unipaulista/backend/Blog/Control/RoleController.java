package br.edu.unipaulista.backend.Blog.Control;

import br.edu.unipaulista.backend.Blog.Service.RoleService;
import br.edu.unipaulista.backend.Blog.domainModel.Role;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> findAll(){
        return ResponseEntity.ok(this.roleService.findAll());
    }

    // GET http://localhost:8080/role/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable Long id){
        return ResponseEntity.ok(this.roleService.findById(id));
    }

    // DELETE http://localhost:8080/role/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable Long id){
       this.roleService.deleteById(id);
       return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<>(this.roleService.create(role), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody Role role){
        return new ResponseEntity<>(this.roleService.create(role), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Role> patchRole(@RequestBody Role role){
        return new ResponseEntity<>(this.roleService.partialUpdate(role), HttpStatus.CREATED);
    }

}
