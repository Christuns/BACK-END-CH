package br.edu.unipaulista.backend.Blog.domainModel.repositories;

import br.edu.unipaulista.backend.Blog.domainModel.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom<User, UUID> {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<User> findByIdWithProfileAndPostCriteria(UUID id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class);
        Fetch<User, ?> profileFetch = root.fetch("profile", JoinType.LEFT);
        Fetch<User, ?> rolesFetch = root.fetch("roles", JoinType.LEFT);

        criteriaQuery.select(root)
                .distinct(true)
                .where(criteriaBuilder.equal(root.get("id"), id));

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        List<User> users = query.getResultList();

        return users.stream().findFirst();
    }

    @Override
    public List<User> findByMinRolesAndNameLikeCriteria(int minRoles, String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root)
                .where(
                        criteriaBuilder.and(
                                criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.size(root.get("roles")), minRoles),
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name + "%")
                        )
                )
                .orderBy(criteriaBuilder.asc(root.get("name")));
        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }
}
