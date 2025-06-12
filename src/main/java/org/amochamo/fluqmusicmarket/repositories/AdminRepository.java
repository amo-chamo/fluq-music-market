package org.amochamo.fluqmusicmarket.repositories;

import org.amochamo.fluqmusicmarket.models.roles.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmail(String email);

    boolean existsByEmail(String email);
}
