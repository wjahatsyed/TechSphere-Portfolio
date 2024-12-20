package com.wjahatsyed.portfolio.ai_career_mobility_tool.service;

import com.wjahatsyed.portfolio.ai_career_mobility_tool.dto.RoleDto;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.model.Role;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public long addRole(RoleDto roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescription());
        role.setRequiredSkills(roleDto.getRequiredSkills());
        return roleRepository.save(role).getId();
    }

    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> {
                    RoleDto dto = new RoleDto();
                    dto.setId(role.getId());
                    dto.setName(role.getName());
                    dto.setDescription(role.getDescription());
                    dto.setRequiredSkills(role.getRequiredSkills());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public void updateRole(long id, RoleDto roleDto) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescription());
        role.setRequiredSkills(roleDto.getRequiredSkills());
        roleRepository.save(role);
    }

    public void deleteRole(long id) {
        roleRepository.deleteById(id);
    }
}
