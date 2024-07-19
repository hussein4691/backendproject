package school.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.online.model.School;
import school.online.services.SchoolService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/get-school")
    public ResponseEntity<List<School>> listSchool() {
        List<School> schools = schoolService.listSchool();
        return ResponseEntity.ok().body(schools);
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getById(@PathVariable Integer id) {
        Optional<School> school = schoolService.getById(id);
        return school.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<School> post(@RequestBody School school) {
        School createdSchool = schoolService.post(school);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchool);
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Integer id, @RequestBody School schoolDetails) {
        School updatedSchool = schoolService.updateSchool(id, schoolDetails);
        if (updatedSchool != null) {
            return ResponseEntity.ok().body(updatedSchool);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        schoolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
