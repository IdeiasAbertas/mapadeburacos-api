package ao.co.mapaDeBuraco.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/user").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/hole/**").permitAll()
                .antMatchers(HttpMethod.POST,"/hole").permitAll()
                .antMatchers(HttpMethod.PUT,"/hole/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/hole/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/comment/**").permitAll()
                .antMatchers(HttpMethod.POST,"/comment").permitAll()
                .antMatchers(HttpMethod.PUT,"/comment/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/comment/**").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated() //.anyRequest().permitAll();
                .and()
                .csrf().disable();
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
