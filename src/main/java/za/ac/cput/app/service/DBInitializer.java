package za.ac.cput.app.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.app.model.User;
import za.ac.cput.app.repository.UserRepository;

import java.util.Arrays;

import static za.ac.cput.app.model.UserRole.ADMIN;
import static za.ac.cput.app.model.UserRole.USER;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/4/2022 | 2:53 AM
 *
 * <p>Project spring-security-basics</p>
 */
@Service
@AllArgsConstructor
public class DBInitializer implements CommandLineRunner {

    private BCryptPasswordEncoder encoder;
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
    repository.saveAll(Arrays.asList(
            new User(
                    "John",
                    encoder.encode("john@123"),
                    "john@doe.org",
                    USER.name()
            ),
            new User(
                    "Mac",
                    encoder.encode("mac@123"),
                    "mac@doe.org",
                    ADMIN.name()
            )
    ));
    }
}
