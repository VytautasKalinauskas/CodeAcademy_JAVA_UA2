package lt.codeacademy.springdataexample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/exams**").permitAll() // Everyone can access all /exams EPs
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails student = User
                .withUsername("student")
                .password(passwordEncoder().encode("student1"))
                .roles("STUDENT")
                .build();

        UserDetails teacher = User
                .withUsername("teacher")
                .password(passwordEncoder().encode("teacher1"))
                .roles("TEACHER")
                .build();

        UserDetails guest = User
                .withUsername("guest")
                .password(passwordEncoder().encode("guest1"))
                .roles("GUEST")
                .build();

        UserDetails[] userDetails = new UserDetails[]{student, teacher, guest};
        return new InMemoryUserDetailsManager(userDetails);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

}
