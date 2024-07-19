package school.online.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.online.model.Admin;
import school.online.model.Students;
import school.online.services.AdminService;
import school.online.services.StudentsService;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/Admin")
public class AdminController {
    @Autowired
    public AdminService adminService;

    @PostMapping("/post-admin")
    public Admin post(@RequestBody Admin admin) {
        return adminService.post(admin);
    }

    @GetMapping("/get-admin")
    public List<Admin> listAdmin() {
        return adminService.listAdmin();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getById(@PathVariable Integer id) {
        return adminService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        adminService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }
}

