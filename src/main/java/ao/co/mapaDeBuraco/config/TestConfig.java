package ao.co.mapaDeBuraco.config;

import ao.co.mapaDeBuraco.model.Admin;
import ao.co.mapaDeBuraco.model.Role;
import ao.co.mapaDeBuraco.repositories.AdminRepository;
import ao.co.mapaDeBuraco.repositories.RoleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static ao.co.mapaDeBuraco.enums.RoleName.ADMIN;
import static ao.co.mapaDeBuraco.enums.RoleName.USER;

@Configuration
@Profile("test")
public class TestConfig {

    final AdminRepository adminRepository;
    final RoleRepository roleRepository;

    public TestConfig(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
    }

    @Bean
    public void startDB() {
        var admin1 = new Admin("kenneth@kenneth.com","Nepsther",new BCryptPasswordEncoder().encode("12345"));
        var admin2 = new Admin("cage@cage.com","Genius",new BCryptPasswordEncoder().encode("12345"));

        var role = new Role(ADMIN);
        var role1 = new Role(USER);
        roleRepository.saveAll(List.of(role, role1));

        admin1.getRoles().add(role);
        admin2.getRoles().add(role1);
        adminRepository.saveAll(List.of(admin1, admin2));

    }

}
