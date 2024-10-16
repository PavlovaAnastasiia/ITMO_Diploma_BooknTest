package project.bookntest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.bookntest.models.ServiceBooking;
import project.bookntest.models.dto.ServiceBookingDTO;
import project.bookntest.services.ServiceBookingService;

import java.util.List;

@Controller
@RequestMapping("/booking")
@RequiredArgsConstructor
public class ServiceBookingController {

    private final ServiceBookingService serviceBookingService;

    @PostMapping("book")
    public String book(@RequestBody List<ServiceBookingDTO> bookingDTOs) {
        if (bookingDTOs == null) {
            System.out.println("Список DTO пуст");
        } else {
            System.out.println("Размер списка DTO: " + bookingDTOs.size());
            for (ServiceBookingDTO serviceBookingDTO : bookingDTOs) {
                System.out.println( serviceBookingDTO.toString());
            }
        }
        serviceBookingService.bookMultipleServices(bookingDTOs);
        return "booking";
    }

    @GetMapping("own-reservations")
    public String ownReservations(Model model) {
        String email = "nastyap968@gmail.com"; // Статично указан email пользователя
        List<ServiceBooking> usersBooking = serviceBookingService.getReservationsByUser(email);
        model.addAttribute("usersBooking", usersBooking);
        return "profile";
    }

    @PostMapping("/delete/{bookingId}")
    public String deleteBooking(@PathVariable("bookingId") int bookingId) {
        // Не ищем пользователя, так как email статичен
        System.out.println("Удаление бронирования с ID: " + bookingId); // Логирование
        boolean isDeleted = serviceBookingService.deleteBookingById(bookingId);

        if (isDeleted) {
            System.out.println("Бронирование успешно удалено");
        } else {
            System.out.println("Бронирование не найдено");
        }
        return "redirect:/booking/own-reservations"; // Перенаправление обратно на страницу с бронированиями
    }
}
