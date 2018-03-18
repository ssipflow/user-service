package io.toanyone.user;

import io.toanyone.user.domain.User;
import io.toanyone.user.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UserRepository repository;


	@Bean
	InitializingBean sendDatabase() {
		User user = new User();

		user.setSeq(1);
		user.setRealName("Leonardo Park");
		user.setUserName("user");
		user.setUserPass("12345678");
		user.setEnabled(true);
		user.setCredentialsNonExpired(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setRoles("ROLE_USER");

		return () -> {
			repository.save(user);
		};
	}
}
