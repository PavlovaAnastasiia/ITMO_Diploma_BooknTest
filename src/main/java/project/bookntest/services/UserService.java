package project.bookntest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.bookntest.models.User;
import project.bookntest.repos.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepo userRepo;


    public Optional<User> findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public List<User> findUsersByTwoParts(String firstNameOrLastName, String lastNameOrFirstName) {
        // Поиск по возможным комбинациям имени и фамилии, а также имени и отчества
        return userRepo.findByTwoParts(firstNameOrLastName, lastNameOrFirstName);
    }

    public List<User> findUsersByAllCombinations(String first, String second, String third) {
        // Поиск по всем возможным комбинациям фамилии, имени и отчества
        return userRepo.findByAllCombinations(first, second, third);
    }


}
