package br.edu.unipaulista.backend.Blog.Control;

import br.edu.unipaulista.backend.Blog.Service.ProfileService;
import br.edu.unipaulista.backend.Blog.domainModel.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {
  private final ProfileService profileService;

  @GetMapping
    public ResponseEntity<List<Profile>> findAll(){
      return ResponseEntity.ok(this.profileService.findAll());
  }

    // GET http://localhost:8080/profile/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Profile> findProfileById(@PathVariable Long id){
      return ResponseEntity.ok(this.profileService.findById(id));
    }

    // DELETE http://localhost:8080/profile/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfileById(@PathVariable Long id){
      this.profileService.deleteById(id);
      return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Profile> createdProfile(@RequestBody Profile profile){
      return new ResponseEntity<>(this.profileService.create(profile), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile){
      return new ResponseEntity<>(this.profileService.update(profile), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Profile> patchProfile(@RequestBody Profile profile){
      return new ResponseEntity<>(this.profileService.partialUpdate(profile), HttpStatus.CREATED);
    }
}
