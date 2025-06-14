package org.amochamo.fluqmusicmarket.repositories.roles;

import org.amochamo.fluqmusicmarket.models.roles.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
