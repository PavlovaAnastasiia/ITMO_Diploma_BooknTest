package project.bookntest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.bookntest.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    List<User> findByFirstNameLikeIgnoreCaseAndLastNameLikeIgnoreCaseAndMiddleNameLikeIgnoreCase(String firstName, String lastName, String middleName);

    List<User> findByFirstNameLikeIgnoreCaseAndLastNameLikeIgnoreCase(String firstName, String lastName);

    @Query("SELECT u FROM User u WHERE " +
            "(u.firstName = :firstNameOrLastName AND u.lastName = :lastNameOrFirstName) OR " +
            "(u.firstName = :lastNameOrFirstName AND u.lastName = :firstNameOrLastName) OR " +
            "(u.firstName = :firstNameOrLastName AND u.middleName = :lastNameOrFirstName) OR " +
            "(u.firstName = :lastNameOrFirstName AND u.middleName = :firstNameOrLastName)")
    List<User> findByTwoParts(@Param("firstNameOrLastName") String firstNameOrLastName,
                              @Param("lastNameOrFirstName") String lastNameOrFirstName);

    @Query("SELECT u FROM User u WHERE " +
            "(u.firstName = :first AND u.lastName = :second AND u.middleName = :third) OR " +
            "(u.firstName = :first AND u.middleName = :second AND u.lastName = :third) OR " +
            "(u.firstName = :second AND u.lastName = :first AND u.middleName = :third) OR " +
            "(u.firstName = :second AND u.middleName = :first AND u.lastName = :third) OR " +
            "(u.firstName = :third AND u.lastName = :first AND u.middleName = :second) OR " +
            "(u.firstName = :third AND u.middleName = :first AND u.lastName = :second)")
    List<User> findByAllCombinations(@Param("first") String first,
                                     @Param("second") String second,
                                     @Param("third") String third);



}
