package br.edu.unipaulista.backend.Blog.domainModel;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    private @Getter @Setter long id;
    private @Getter @Setter String title;
    private @Getter @Setter String content;
    private @Getter @Setter User user;
    private @Getter @Setter Set<Tag> tags;
}
