package ao.co.mapaDeBuraco.config;

import ao.co.mapaDeBuraco.model.Admin;
import ao.co.mapaDeBuraco.model.Comment;
import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.repositories.AdminRepository;
import ao.co.mapaDeBuraco.repositories.CommentRepository;
import ao.co.mapaDeBuraco.repositories.HoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private HoleRepository holeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Bean
    public void startDB(){
        var admin1 = new Admin("kenneth@kenneth.com","Nepsther","1234");
        var admin2 = new Admin("cage@cage.com","Genius","1234");
        adminRepository.saveAll(List.of(admin1, admin2));

        var  hole1 = new Hole("picture","description","01232343","1234","Rua da dira","Luanda",null);
        var  hole2 = new Hole ("picture","description","01232343","1234","Rua da dira","Luanda",null);


        var  comment1 = new Comment("yes we can comment",null, hole1);
        var  comment2 = new Comment("yes we can comment",null, hole2);

        hole1.getComments().add(comment1);
        hole2.getComments().add(comment2);

        holeRepository.saveAll(List.of(hole1, hole2));
        commentRepository.saveAll(List.of(comment1, comment2));

    }

}
