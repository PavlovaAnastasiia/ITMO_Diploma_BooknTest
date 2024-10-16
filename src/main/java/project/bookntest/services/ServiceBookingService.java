package project.bookntest.services;

import lombok.RequiredArgsConstructor;
import project.bookntest.models.Service;
import org.springframework.transaction.annotation.Transactional;
import project.bookntest.models.ServiceBooking;
import project.bookntest.models.User;
import project.bookntest.models.dto.ServiceBookingDTO;
import project.bookntest.repos.ServiceBookingRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceBookingService {

    private final ServiceBookingRepo serviceBookingRepo;
    private final ServicesService servicesService;
    private final UserService userService;

    @Transactional
    public void bookMultipleServices(List<ServiceBookingDTO> bookingDTOs) {
        System.out.println(bookingDTOs.toString());

        for (ServiceBookingDTO bookingDTO : bookingDTOs) {
            ServiceBooking serviceBooking = new ServiceBooking();
            serviceBooking.setEnvironment(bookingDTO.getEnvironment());
            serviceBooking.setStartBooking(bookingDTO.getStartBooking());
            serviceBooking.setEndBooking(bookingDTO.getEndBooking());
            serviceBooking.setBDate(new Date());

            User user = userService.findUserByEmail(bookingDTO.getEmail())
                    .orElseThrow(() -> new RuntimeException("User with email " + bookingDTO.getEmail() + " not found"));


            user.addServiceBooking(serviceBooking);

            Service service = servicesService.findByServiceNameIgnoreCase(bookingDTO.getServiceName())
                    .orElseThrow(() -> new RuntimeException("Service with name " + bookingDTO.getServiceName() + " not found"));

            service.setBooked(true);
            serviceBooking.setService(service);

            serviceBookingRepo.save(serviceBooking);
        }
    }

    public List<ServiceBooking> getReservationsByUser(String email) {
        return serviceBookingRepo.findByUser_EmailIgnoreCaseAndService_BookedTrue(email);
    }

    // Метод для удаления бронирования с транзакцией
    @Transactional
    public boolean deleteBookingById(int bookingId) {
        Optional<ServiceBooking> booking = serviceBookingRepo.findById(bookingId);

        if (booking.isPresent()) {
            // Получаем бронирование
            ServiceBooking serviceBooking = booking.get();

            // Удаляем бронирование
            serviceBookingRepo.delete(serviceBooking);

            // Находим сервис, связанный с этим бронированием
            Service service = serviceBooking.getService();

            // Изменяем статус сервиса на "false" (сделать недоступным)
            service.setBooked(false); // Меняем статус сервиса на "не забронирован"

            return true; // Успешное удаление и обновление статуса сервиса
        } else {
            return false; // Бронирование не найдено
        }
    }

}
