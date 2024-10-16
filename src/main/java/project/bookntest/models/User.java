package project.bookntest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @Email(message = "Email is not valid")
    @Size(min = 1, max = 120, message = "Email should be between 1 and 120 characters")
    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    @Size(min = 1, max = 50, message = "First name should be between 1 and 50 characters")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    @Size(min = 1, max = 80, message = "Last name should be between 1 and 80 characters")
    @NonNull
    private String lastName;

    @Column(name = "middle_name")
    @NotBlank(message = "Middle name is required")
    @Size(min = 1, max = 40, message = "Middle name should be between 1 and 40 characters")
    @NonNull
    private String middleName;

    @Column(name = "phone_number")
    @NotBlank(message = "Phone number is required")
    @Size(min = 8, max = 12, message = "Phone number should be between 8 and 12 characters")
    @NonNull
    private String phoneNumber;

    @Column(name = "profile_picture")
    @Size(min = 1, max = 40, message = "Profile picture should be between 1 and 40 characters")
    @NonNull
    private String profilePicture;

    @Column(name = "password")
    @NotBlank(message = "Password is required")
    @Size(min = 1, max = 50, message = "Password should be between 1 and 50 characters")
    @NonNull
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;

    @OneToMany(mappedBy = "user")
    private List<ServiceBooking> serviceBookings;

    // Вспомогательный метод для добавления бронирования
    public void addServiceBooking(ServiceBooking serviceBooking) {
        this.serviceBookings.add(serviceBooking);
        serviceBooking.setUser(this); // Устанавливаем обратную связь
    }

    // Вспомогательный метод для удаления бронирования
    public void removeServiceBooking(ServiceBooking serviceBooking) {
        this.serviceBookings.remove(serviceBooking);
        serviceBooking.setUser(null); // Удаляем обратную связь
    }
}
