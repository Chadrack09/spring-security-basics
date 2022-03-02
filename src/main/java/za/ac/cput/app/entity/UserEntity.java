package za.ac.cput.app.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/27/2022 | 12:28 PM
 *
 * <p>Project spring-security-basics</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;

  @Column(length = 60)
  private String password;

  @Email
  private String email;
  private String ROLE;
  private boolean enabled = false;

  public UserEntity(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }
}
