package org.amochamo.fluqmusicmarket.services.roles;

import org.amochamo.fluqmusicmarket.repositories.roles.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
}
