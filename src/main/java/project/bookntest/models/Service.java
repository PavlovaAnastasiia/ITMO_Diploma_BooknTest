package project.bookntest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int id;

    @Column(name = "service_name")
    @NotBlank(message = "Service name is required")
    @Size(min = 1, max = 80, message = "Service name should be between 1 and 80 characters")
    @NonNull
    private String serviceName;

    @Column(name = "status")
    private boolean booked = false; // TODO: keep default value or not?

    @OneToOne(mappedBy = "service")
    private ServiceBooking serviceBooking;
}
