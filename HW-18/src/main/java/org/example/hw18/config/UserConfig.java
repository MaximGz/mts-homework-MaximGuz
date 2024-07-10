package org.example.hw18.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService user(PasswordEncoder passwordEncoder) {
        System.out.println("Creating users during application startup...");
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

        System.out.println("Users created successfully.");
        return jdbcUserDetailsManager;
    }

//    //Конфигурация In-Memory аутентификации:
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails admin = User.builder().username("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").build();
//        UserDetails user = User.builder().username("user").password(passwordEncoder.encode("user123")).roles("USER").build();
//        UserDetails max = User.builder().username("max").password(passwordEncoder.encode("maxim")).roles("ADMIN", "USER").build();
//        return new InMemoryUserDetailsManager(admin, user, max);
//    }
}
