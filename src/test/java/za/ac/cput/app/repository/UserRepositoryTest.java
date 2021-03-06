package za.ac.cput.app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    public void selectUsername() {
        System.out.println("Username: " +
                repository.selectUsername("test@test.com"));
    }

    @Test
    public void updateUser() {
        repository.updateUser("Carl", "carl#123",
                "carl@carl.com", 1l);
    }

    @Test
    public void findByUsername() {
        System.out.println(repository.findByUsername("John"));
    }
}