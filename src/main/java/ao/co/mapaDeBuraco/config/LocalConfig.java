package ao.co.mapaDeBuraco.config;

import ao.co.mapaDeBuraco.model.Administrator;
import ao.co.mapaDeBuraco.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Bean
    public void startDB(){
        var administrator1 = new Administrator("kenneth@kenneth.com","Nepsther","1234");
        var administrator2 = new Administrator("cage@cage.com","Genius","1234");

        administratorRepository.saveAll(List.of(administrator1, administrator2));

    }

}
