package project.bookntest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.bookntest.models.ServiceBooking;

import java.util.List;


@Repository
public interface ServiceBookingRepo extends JpaRepository<ServiceBooking, Integer> {
    List<ServiceBooking> findByUser_EmailIgnoreCaseAndService_BookedTrue(String email);
}
