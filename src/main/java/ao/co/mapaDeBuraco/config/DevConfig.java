package ao.co.mapaDeBuraco.config;

import ao.co.mapaDeBuraco.model.Admin;
import ao.co.mapaDeBuraco.model.Comment;
import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.model.Role;
import ao.co.mapaDeBuraco.repositories.AdminRepository;
import ao.co.mapaDeBuraco.repositories.CommentRepository;
import ao.co.mapaDeBuraco.repositories.HoleRepository;
import ao.co.mapaDeBuraco.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static ao.co.mapaDeBuraco.enums.RoleName.ADMIN;
import static ao.co.mapaDeBuraco.enums.RoleName.USER;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private HoleRepository holeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public void startDB() throws IOException {
//        var admin1 = new Admin("kenneth@kenneth.com","Nepsther",new BCryptPasswordEncoder().encode("12345"));
//        var admin2 = new Admin("cage@cage.com","Genius",new BCryptPasswordEncoder().encode("12345"));


        var role = new Role(ADMIN);
        var role1 = new Role(USER);
        roleRepository.saveAll(List.of(role, role1));

        var admin1 = new Admin("kenneth@kenneth.com","Nepsther",new BCryptPasswordEncoder().encode("12345"),List.of(role));
        var admin2 = new Admin("cage@cage.com","Genius",new BCryptPasswordEncoder().encode("12345"),List.of(role1));

        //admin1.getRoles().add(role);
        //admin2.getRoles().add(role1);

        adminRepository.saveAll(List.of(admin1, admin2));




        var  hole1 = new Hole("picture1".getBytes(),"description1","01232343","1234","Rua da dira","Luanda",null);

        var  hole2 = new Hole ("picture1".getBytes(),"description2","01232343","1234","Malueca","Benguela",null);
        var  hole3 = new Hole ("picture1".getBytes(),"description3","01232343","1234","kangojo","Moxico",null);
        var  hole4 = new Hole ("picture1".getBytes(),"description4","01232343","1234","vila flor","BIE",null);
        var  hole5 = new Hole ("picture1".getBytes(),"description5","01232343","1234","executive","Lunada",null);


        var  comment1 = new Comment("A is simply dummy text of the printing a",null, hole1);
        var  comment2 = new Comment("B is simply dummy text of the printing a",null, hole1);
        var  comment3 = new Comment("C is simply dummy text of the printing a",null, hole1);
        var  comment4 = new Comment("D is simply dummy text of the printing a",null, hole1);
        var  comment5 = new Comment("E is simply dummy text of the printing a",null, hole2);
        var  comment6 = new Comment("F is simply dummy text of the printing a",null, hole2);
        var  comment7 = new Comment("G is simply dummy text of the printing a",null, hole3);
        var  comment8 = new Comment("H is simply dummy text of the printing a",null, hole3);
        var  comment9 = new Comment("H is simply dummy text of the printing a",null, hole4);


        hole1.getComments().addAll(Arrays.asList(comment1, comment2, comment3, comment4));
        hole2.getComments().addAll(Arrays.asList(comment5, comment6));
        hole3.getComments().addAll(Arrays.asList(comment7, comment8));
        hole4.getComments().addAll(Arrays.asList(comment9));

        holeRepository.saveAll(List.of(hole1, hole2,hole3,hole4,hole5));
        commentRepository.saveAll(List.of(comment1, comment2, comment3, comment4, comment5, comment6, comment7, comment8,comment9));

    }

}
