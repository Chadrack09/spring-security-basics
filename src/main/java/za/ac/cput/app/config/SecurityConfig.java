package za.ac.cput.app.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import za.ac.cput.app.model.UserRole;

import static za.ac.cput.app.model.UserRole.ADMIN;
import static za.ac.cput.app.model.UserRole.USER;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/3/2022 | 6:06 PM
 *
 * <p>Project spring-security-basics</p>
 */
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("marc")
                .password("$2a$05$2FifpdopObzkeSE1.NJM..qEaSnYAaOfB758lloERZ8plpnGvazKG")
                .roles(USER.name())
                .and()
                .withUser("admin")
                .password("$2a$05$tlTgdetB.rN7RE1KRXklMOtIbxBjv46z3e96amDX9E5S4s0VKHAO.")
                .roles(ADMIN.name());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/registration").hasRole(USER.name())
                .antMatchers("/admin").hasRole(ADMIN.name())
                .and()
                .formLogin()
                    .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                    .and()
                    .rememberMe() // The default is set up to 2 weeks
                    .and()
                    .logout()
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID", "remember-me")
                        .logoutSuccessUrl("/login")
        ;
    }


}
