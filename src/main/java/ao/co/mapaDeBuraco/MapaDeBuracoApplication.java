package ao.co.mapaDeBuraco;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MapaDeBuracoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapaDeBuracoApplication.class, args);


	}

}
