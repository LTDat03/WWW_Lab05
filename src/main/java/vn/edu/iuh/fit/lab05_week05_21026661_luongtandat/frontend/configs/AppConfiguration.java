/*
 * @ (#) AppConfiguration.java       1.0     12/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.configs;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/12/2024
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppConfiguration {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/"))
                .disable()
            .authorizeRequests()
                .requestMatchers("/auth/login", "/auth/register").permitAll() // Cho phép truy cập tự do
                .anyRequest().authenticated() // Yêu cầu xác thực cho các yêu cầu còn lại
            .and()
            .formLogin()
                .loginPage("/auth/login")
                .loginProcessingUrl("/do-login")
                .defaultSuccessUrl("/index", true) // Điều hướng sau khi đăng nhập thành công
                .permitAll()
            .and()
            .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                .logoutSuccessUrl("/auth/login?logout")
                .permitAll()
            .and()
            .httpBasic().disable();
        return httpSecurity.build();
    }
}
