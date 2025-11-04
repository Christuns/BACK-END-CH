package br.edu.unipaulista.backend.Blog.domainModel;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tag {
    private @Getter @Setter long id;
    private @Getter @Setter String name;
    private @Getter @Setter Set<Post> post;
}
