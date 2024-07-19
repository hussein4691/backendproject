package school.online.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.online.model.School;
import school.online.model.Students;
import school.online.repository.StudentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    public Students registerStudent(Students students) {
        return studentsRepository.save(students);
    }

    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    public Optional<Students> getStudentById(Integer id) {
        return studentsRepository.findById(id);
    }

    public void deleteStudentById(Integer id) {
        studentsRepository.deleteById(id);
    }

    public Students updateStudents(Integer id, Students studentsDetails) {
        Students students = studentsRepository.findById(id).orElse(null);
        if (students != null) {
            students.setStudName(studentsDetails.getStudName());
            students.setAge(studentsDetails.getAge());
            students.setEmail(studentsDetails.getEmail());
            students.setGender(studentsDetails.getGender());
            return studentsRepository.save(students);
        }
        return null;
    }
}
