package school.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.online.model.Students;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
}
