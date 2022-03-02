package za.ac.cput.app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import za.ac.cput.app.entity.UserEntity;
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

  public void register(UserModel userModel) {

    if(checkEmailExist(userModel.getEmail())) {
      throw new RuntimeException("Email already exists");
    }
    else {
      UserEntity userEntity = new UserEntity();
      userEntity.setEmail(userModel.getEmail());
      userEntity.setUsername(userModel.getUsername());
      userEntity.setPassword(userModel.getPassword());
      userEntity.setROLE("USER");

      UserEntity save = repository.save(userEntity);
    }
  }

  private boolean checkEmailExist(String email) {

    Optional<UserEntity> optional = repository.findByEmail(email);
    return optional.isPresent() ? true : false;
  }
}
