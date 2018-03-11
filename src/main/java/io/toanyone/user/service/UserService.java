package io.toanyone.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.toanyone.user.domain.User;
import io.toanyone.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @HystrixCommand(commandKey = "사용자조회",fallbackMethod = "queryByUserNameFallBack"
            ,threadPoolKey = "QueryUser", threadPoolProperties = {
            @HystrixProperty(name="coreSize", value="10"),
            @HystrixProperty(name="maxQueueSize", value="10")
    })
    public Optional<User> queryByUserName(String userId) {
        return repository.findByUserName(userId);
    }

    public Optional<User> queryByUserNameFallBack(String userId) {
        return Optional.empty();
    }

}
