package school.online.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.online.model.School;
import school.online.repository.SchoolRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> listSchool() {
        return schoolRepository.findAll();
    }

    public Optional<School> getById(Integer id) {
        return schoolRepository.findById(id);
    }

    public School post(School school) {
        return schoolRepository.save(school);
    }

    public School updateSchool(Integer id, School schoolDetails) {
        School school = schoolRepository.findById(id).orElse(null);
        if (school != null) {
            school.setSchoolName(schoolDetails.getSchoolName());
            school.setAddress(schoolDetails.getAddress());
            school.setEmail(schoolDetails.getEmail());
            school.setDescriptions(schoolDetails.getDescriptions());
            return schoolRepository.save(school);
        }
        return null;
    }

    public void deleteById(Integer id) {
        schoolRepository.deleteById(id);
    }


    public Optional<School> getSchoolById(int id) {
        return schoolRepository.findById(id);
    }



}
