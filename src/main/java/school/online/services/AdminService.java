package school.online.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.online.model.Admin;
import school.online.model.Students;
import school.online.repository.AdminRepository;
import school.online.repository.StudentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    public AdminRepository adminRepository;

    public Admin post(Admin admin){
        return adminRepository.save(admin);
    }
    public List<Admin> listAdmin(){
        return adminRepository.findAll();
    }

    public Optional<Admin> getById(Integer id) {
        return adminRepository.findById(id);
    }

    public void deleteById(Integer id){
        adminRepository.deleteById(id);
    }

    public  Admin updateAdmin(int id, Admin adminDetails){
        Admin admin=adminRepository.findById(id).orElse(null);
        if (admin != null){
            admin.setAdminId(adminDetails.getAdminId());
            admin.setAdminName(adminDetails.getAdminName());
            admin.setGender(adminDetails.getGender());
            admin.setEmail(adminDetails.getEmail());
            return adminRepository.save(admin);
        }
        return null;
    }
}
