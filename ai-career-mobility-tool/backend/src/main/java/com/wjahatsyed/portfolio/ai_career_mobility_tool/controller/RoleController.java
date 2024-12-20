package com.wjahatsyed.portfolio.ai_career_mobility_tool.controller;

import com.wjahatsyed.portfolio.ai_career_mobility_tool.dto.RoleDto;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/career-mobility/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto) {
        long roleId = roleService.addRole(roleDto);
        return ResponseEntity.ok("Role added successfully with ID: " + roleId);
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@PathVariable long id, @RequestBody RoleDto roleDto) {
        roleService.updateRole(id, roleDto);
        return ResponseEntity.ok("Role updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable long id) {
        roleService.deleteRole(id);
        return ResponseEntity.ok("Role deleted successfully.");
    }
}
