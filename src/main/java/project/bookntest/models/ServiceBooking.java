package project.bookntest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "services_bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_b_id")
    private int id;

    @Column(name = "environment")
    @NotBlank(message = "Environment name is required")
    @Size(min = 1, max = 25, message = "Environment name should be between 1 and 100 characters")
    @NonNull
    private String environment;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    @NonNull
    private User user;

    @OneToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Service service;

    @Column(name = "start_booking")
    @NonNull
    private LocalTime startBooking;

    @Column(name = "end_booking")
    @NonNull
    private LocalTime endBooking;

    @Column(name = "b_date")
    @Temporal(TemporalType.DATE)
    private Date bDate;
}
