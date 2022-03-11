package za.ac.cput.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 2/27/2022 | 11:04 PM
 *
 * <p>Project spring-security-basics</p>
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private String username;
    private String password;
    private String matchPassword;
    private String email;
    private String roles;
}
