package br.edu.unipaulista.backend.Blog.domainModel.repositories;

import br.edu.unipaulista.backend.Blog.domainModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends
        JpaRepository<User, UUID>,
        QuerydslPredicateExecutor<User>,
        UserRepositoryCustom<User, UUID> {

    @Query("""
        SELECT u FROM User u WHERE u.email= :email
""")
    public Optional<User> findByEmail(String email);

    public Optional<User> findByName(String name);
    public Optional<User> findByNameAndEmail(String name, String email);
    public List<User> findByNameStartingWithAndNameEndingWith(String name1, String name2);

    //Q1 JPQL busca  usuario por ID e faz fatch com profile e post
    @Query("""
    select distinct u
    from User  u
    left join fetch u.profile
    left join fetch u.roles
    where u.id = :id
""")
    Optional<User> findByIdWithProfileAndPost(@Param("id") UUID id);

    //Q2 JPQL usuarios cujo o nome contem um parametro que tenha pelo menos n roles
    @Query("""
    select u
    from User u
    where size(u.roles) >= :minRoles
    and lower(u.name) like lower(concat('%', :namePart, '%'))
    order by u.name asc
""")
    List<User> findMinPostAndNameLike(@Param("minPosts") int minPosts, @Param("namePart") String namePart);


    interface UserRepositoryCustom {
    }
}
