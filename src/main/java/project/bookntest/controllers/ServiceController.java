package project.bookntest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.bookntest.models.Service;
import project.bookntest.services.ServicesService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServicesService servicesService;

    @GetMapping("/all-booked")
    public String getAllBookedServices(Model model){
        List<Service> bookedServices = servicesService.getAllBookedServices();
        model.addAttribute("bookedServices", bookedServices);
        return "index";
    }

    @GetMapping("/contacts")
    public String showContactsPage(Model model) {
        // Получаем забронированные сервисы
        List<Service> bookedServices = servicesService.getAllBookedServices();

        // Создаем множество для отслеживания уникальных email
        Set<String> seenEmails = new HashSet<>();

        // Фильтруем забронированные сервисы по уникальным email
        List<Service> uniqueBookedServices = bookedServices.stream()
                .filter(service -> seenEmails.add(service.getServiceBooking().getUser().getEmail())) // Добавляем email, если его еще не было
                .collect(Collectors.toList());

        // Добавляем уникальные забронированные сервисы в модель
        model.addAttribute("bookedServices", uniqueBookedServices);

        return "contacts";
    }

    @GetMapping("/find-booked")
    public String findBookedServices(@RequestParam String serviceName, Model model){
        List<Service> searchedServices = servicesService.searchBookedService(serviceName);
        model.addAttribute("searchedServices", searchedServices);

        return "index";
    }

    @GetMapping("/all-free")
    public String getAllFreeServices(Model model){
        List<Service> freeServices = servicesService.getAllFreeServices();
        model.addAttribute("freeServices", freeServices);

        return "booking";
    }

    @GetMapping("/find-free")
    public String findFreeServices(@RequestParam String serviceName, Model model) {
        // Предположим, что метод searchFreeService ищет свободные сервисы по названию
        List<Service> searchedServices = servicesService.searchFreeService(serviceName);

        // Добавляем найденные свободные сервисы в модель для отображения на странице
        model.addAttribute("searchedServices", searchedServices);

        // Возвращаем название шаблона, который будет отображаться (например, index.html)
        return "booking";
    }
}
