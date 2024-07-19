package school.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.online.model.School;
import school.online.model.Students;
import school.online.services.StudentsService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/students") // Ensure the correct mapping
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @PostMapping("/register")
    public Students registerStudent(@RequestBody Students students) {
        return studentsService.registerStudent(students);
    }

    @GetMapping("/get-all")
    public List<Students> getAllStudents() {
        return studentsService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Students> getStudentById(@PathVariable Integer id) {
        return studentsService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        studentsService.deleteStudentById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Students> updateStudents(@PathVariable Integer id, @RequestBody Students studentsDetails) {
        Students updatedStudents = studentsService.updateStudents(id, studentsDetails);
        if (updatedStudents != null) {
            return ResponseEntity.ok().body(updatedStudents);
        }
        return ResponseEntity.notFound().build();
    }
}
