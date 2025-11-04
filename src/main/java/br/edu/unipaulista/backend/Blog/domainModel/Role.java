package br.edu.unipaulista.backend.Blog.domainModel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private @Getter @Setter long id;

    @Column(name = "NAEME", nullable = false, length = 20)
    private @Getter @Setter String name;

    @ManyToMany
    private @Getter @Setter Set<User> user;
}
