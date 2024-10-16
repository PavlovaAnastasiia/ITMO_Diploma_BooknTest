package project.bookntest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    @NotBlank(message = "Role name is required")
    @Size(min = 1, max = 40, message = "Role name should be between 1 and 40 characters")
    @NonNull
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
