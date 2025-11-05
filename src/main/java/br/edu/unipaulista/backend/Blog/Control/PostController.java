package br.edu.unipaulista.backend.Blog.Control;

import br.edu.unipaulista.backend.Blog.Service.PostService;
import br.edu.unipaulista.backend.Blog.domainModel.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(this.postService.findAll());
    }

    // GET http://localhost:8080/post/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable UUID id){
        return ResponseEntity.ok(this.postService.findById(id));
    }

    // DELETE http://localhost:8080/post/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable UUID id){
        this.postService.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        return new ResponseEntity<>(this.postService.create(post), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        return new ResponseEntity<>(this.postService.update(post), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Post> patchPost(@RequestBody Post post){
        return new ResponseEntity<>(this.postService.partialUpdate(post), HttpStatus.CREATED);
    }
}
