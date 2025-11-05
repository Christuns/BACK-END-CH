package br.edu.unipaulista.backend.Blog.Control;

import br.edu.unipaulista.backend.Blog.Service.TagService;
import br.edu.unipaulista.backend.Blog.domainModel.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> findAll(){
        return ResponseEntity.ok(this.tagService.findAll());
    }

    // GET http://localhost:8080/tag/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Tag> findTagById(@PathVariable Long id){
        return ResponseEntity.ok(this.tagService.findById(id));
    }

    // DELETE http://localhost:8080/tag/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTagById(@PathVariable Long id){
        this.tagService.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag ){
        return new ResponseEntity<>(this.tagService.create(tag), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag){
        return new ResponseEntity<>(this.tagService.update(tag), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Tag> patchTag(@RequestBody Tag tag){
        return new ResponseEntity<>(this.tagService.partialUpdate(tag),HttpStatus.CREATED);
    }
}
