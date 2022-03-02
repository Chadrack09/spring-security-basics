package za.ac.cput.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.app.entity.UserEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/27/2022 | 12:37 PM
 *
 * <p>Project spring-security-basics</p>
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  @Query("SELECT u FROM UserEntity u WHERE u.username = ?1")
  UserEntity getUserByName(String username);

  @Query("SELECT u.username FROM UserEntity u WHERE u.email = ?1")
  String selectUsername(String email);

  @Transactional
  @Modifying(clearAutomatically = true)
  @Query(value = "UPDATE User SET username = ?1 WHERE id = ?2", nativeQuery = true)
  void updateUsername(String username, Long id);

  @Transactional
  @Modifying(clearAutomatically = true)
  @Query(value = "UPDATE UserEntity SET username = ?1, " +
          "password = ?2, email = ?3 WHERE id = ?4")
  void updateUser(String username, String password, String email, Long id);

  Optional<UserEntity> findByEmail(String email);
}
