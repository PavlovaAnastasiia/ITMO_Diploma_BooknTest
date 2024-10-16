package project.bookntest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.bookntest.models.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepo extends JpaRepository<Service,Integer> {
    List<Service> findByBookedTrue();

    List<Service> findByBookedFalse();

    List<Service> findByServiceNameStartsWithIgnoreCaseAndBookedTrue(String serviceName);

    List<Service> findByServiceNameStartsWithIgnoreCaseAndBookedFalse(String serviceName);

    Optional<Service> findByServiceNameIgnoreCase(String serviceName);
}
