package project.bookntest.services;

import lombok.RequiredArgsConstructor;
import project.bookntest.models.Service;
import org.springframework.transaction.annotation.Transactional;
import project.bookntest.repos.ServiceRepo;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServicesService {

    private final ServiceRepo serviceRepo;

    public Optional<Service> findByServiceNameIgnoreCase(String serviceName){
        return serviceRepo.findByServiceNameIgnoreCase(serviceName);
    }

    public List<Service> getAllBookedServices() {
        return serviceRepo.findByBookedTrue();
    }

    public List<Service> searchBookedService(String serviceName) {
        return serviceRepo.findByServiceNameStartsWithIgnoreCaseAndBookedTrue(serviceName);
    }

    public List<Service> searchFreeService(String serviceName) {
        return serviceRepo.findByServiceNameStartsWithIgnoreCaseAndBookedFalse(serviceName);
    }

    public List<Service> getAllFreeServices() {
        return serviceRepo.findByBookedFalse();
    }

}
