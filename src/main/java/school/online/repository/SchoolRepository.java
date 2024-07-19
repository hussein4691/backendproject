package school.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.online.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
}
