package br.edu.unipaulista.backend.Blog.domainModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue()
    private @Getter @Setter long id;
    private @Getter @Setter String title;
    private @Getter @Setter String content;
    @OneToMany
    private @Getter @Setter User user;
    private @Getter @Setter Set<Tag> tags;

    public Post orElse(Object o) {
        return null;
    }
}
