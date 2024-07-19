package school.online.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.online.model.Admin;
import school.online.model.Students;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
