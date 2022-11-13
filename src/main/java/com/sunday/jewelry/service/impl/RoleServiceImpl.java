package com.sunday.jewelry.service.impl;

import com.sunday.jewelry.repository.RoleRepository;
import com.sunday.jewelry.model.security.Role;
import com.sunday.jewelry.service.abst.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    @PostConstruct
    public void addDefaultRole() {
        roleRepository.saveAll(List.of(
                new Role(1L, "ROLE_USER"),
                new Role(2L, "ROLE_ADMIN"),
                new Role(3L, "ROLE_SUPER_ADMIN")
        ));
    }

    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
      return new HashSet<>(roleRepository.findAllById(roles));
    }
}
