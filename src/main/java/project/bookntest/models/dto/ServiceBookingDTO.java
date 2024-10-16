package project.bookntest.models.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class ServiceBookingDTO{
    private String email;
    private String serviceName;
    private LocalTime startBooking;
    private LocalTime endBooking;
    private String environment;
    private Date bDate;
}
