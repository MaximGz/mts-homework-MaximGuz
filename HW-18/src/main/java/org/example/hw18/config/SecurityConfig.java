package org.example.hw18.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService user(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder().username("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").build();
        UserDetails user = User.builder().username("user").password(passwordEncoder.encode("user123")).roles("USER").build();
        UserDetails max = User.builder().username("max").password(passwordEncoder.encode("maxim")).roles("ADMIN", "USER").build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM db_security.users WHERE username = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM db_security.authorities WHERE username = ?");
        jdbcUserDetailsManager.setCreateUserSql("INSERT INTO db_security.users (username, password, enabled) values (?,?,?)");
        jdbcUserDetailsManager.setCreateAuthoritySql("INSERT INTO db_security.authorities (username, authority) values (?,?)");
        jdbcUserDetailsManager.setDeleteUserAuthoritiesSql("DELETE FROM db_security.authorities WHERE username = ?");
        jdbcUserDetailsManager.setDeleteUserSql("DELETE FROM db_security.users WHERE username = ?");
        jdbcUserDetailsManager.setUpdateUserSql("UPDATE db_security.users SET password = ?, enabled = ? WHERE username = ?");
        jdbcUserDetailsManager.setChangePasswordSql("UPDATE db_security.users SET password = ? WHERE username = ?");
        jdbcUserDetailsManager.createUser(admin);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(max);
        return jdbcUserDetailsManager;
    }

    //Конфигурация In-Memory аутентификации:
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails admin = User.builder().username("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").build();
//        UserDetails user = User.builder().username("user").password(passwordEncoder.encode("user123")).roles("USER").build();
//        UserDetails max = User.builder().username("max").password(passwordEncoder.encode("maxim")).roles("ADMIN", "USER").build();
//        return new InMemoryUserDetailsManager(admin, user, max);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/welcome").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                .build();
    }
}
