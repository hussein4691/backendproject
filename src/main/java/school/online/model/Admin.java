package school.online.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int adminId;
    public String adminName;
    public String gender;
    public String email;
}
