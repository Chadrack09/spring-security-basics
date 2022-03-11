package za.ac.cput.app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.app.model.User;
import za.ac.cput.app.service.UserService;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/27/2022 | 8:37 PM
 *
 * <p>Project spring-security-basics</p>
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

//  @Test
//  public void saveUser() {
//    UserEntity u = UserEntity.builder()
//            .email("test@test.com")
//            .username("Chain")
//            .password("Merc")
//            .ROLE("USER")
//            .build();
//
//    repository.save(u);
//  }

    @Test
    public void selectByName() {
        User u = repository.getUserByName("Chain");
        System.out.println("User = " + u);
    }

    @Test
    public void selectUsername() {
        System.out.println("Username: " +
                repository.selectUsername("test@test.com"));
    }

    @Test
    public void updateUsername() {
        repository.updateUsername("Albert", 1l);
    }

    @Test
    public void updateUser() {
        repository.updateUser("Carl", "carl#123",
                "carl@carl.com", 1l);
    }

//  @Test
//  public void register() {
//    service.register(new UserModel(
//            "Rock",
//            "rock@123",
//            "rock@123",
//            "rock@rock.com"));
//  }
}