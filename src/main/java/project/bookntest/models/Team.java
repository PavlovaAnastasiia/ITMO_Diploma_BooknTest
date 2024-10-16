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
@Table(name = "teams")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int id;

    @Column(name = "team_name")
    @NotBlank(message = "Team name is required")
    @Size(min = 1, max = 40, message = "Team name should be between 1 and 40 characters")
    @NonNull
    private String teamName;

    @OneToMany(mappedBy = "team")
    private List<User> users;
}
