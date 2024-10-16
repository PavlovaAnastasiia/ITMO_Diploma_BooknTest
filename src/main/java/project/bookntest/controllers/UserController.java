package project.bookntest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.bookntest.models.User;
import project.bookntest.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/find")
    public String searchUsersByFullName(@RequestParam String fullName, Model model) {
        // Разделяем fullName на части по пробелам
        String[] nameParts = fullName.trim().split("\\s+");

        if (nameParts.length < 2) {
            // Если в строке меньше двух слов, возвращаем ошибку
            model.addAttribute("error", "Full name must contain at least two words.");
            return "contacts"; // Возвращаем шаблон с ошибкой
        }

        List<User> users;
        if (nameParts.length == 2) {
            // Если указаны только два слова, считаем, что одно из них — это фамилия, а другое — имя или отчество
            String firstNameOrLastName = nameParts[0];
            String lastNameOrFirstName = nameParts[1];
            users = userService.findUsersByTwoParts(firstNameOrLastName, lastNameOrFirstName);
        } else if (nameParts.length == 3) {
            // Если указаны три слова, проверяем все возможные комбинации
            String first = nameParts[0];
            String second = nameParts[1];
            String third = nameParts[2];
            users = userService.findUsersByAllCombinations(first, second, third);
        } else {
            // Если указано более трех слов, возвращаем ошибку
            model.addAttribute("error", "Full name must contain only three parts: last name, first name, and middle name.");
            return "contacts";
        }

        // Добавляем результат в модель
        model.addAttribute("users", users);

        return "contacts"; // Возвращаем шаблон представления с результатами
    }


}
