package za.ac.cput.app.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.app.model.User;
import za.ac.cput.app.model.UserModel;
import za.ac.cput.app.repository.UserRepository;

import java.util.Optional;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/27/2022 | 12:38 PM
 *
 * <p>Project spring-security-basics</p>
 */
@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private PasswordEncoder encoder;

    public void register(UserModel userModel) {

//    if (checkEmailExist(userModel.getEmail())) {
//      throw new RuntimeException("Email already exists");
//    } else {
//      User user = new User();
//      user.setEmail(userModel.getEmail());
//      user.setUsername(userModel.getUsername());
//      user.setPassword(encoder.encode(userModel.getPassword()));
//      user.setRoles(userModel.getRoles());
//
//      User save = repository.save(user);
//    }
    }

    private boolean checkEmailExist(String email) {
        Optional<User> optional = repository.findByEmail(email);
        return optional.isPresent() ? true : false;
    }
}
