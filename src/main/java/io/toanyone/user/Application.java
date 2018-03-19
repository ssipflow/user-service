package io.toanyone.user;

import io.toanyone.user.domain.User;
import io.toanyone.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
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

		return (args) -> {
			repository.save(user);
		};
	}
}
