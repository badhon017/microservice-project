package com.roybadhon.user.service.ServiceImpl;

import com.roybadhon.user.service.entities.Rating;
import com.roybadhon.user.service.entities.User;
import com.roybadhon.user.service.exceptions.ResourceNotFoundException;
import com.roybadhon.user.service.repo.UserRepository;
import com.roybadhon.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user =  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found!"));
        ArrayList<Rating> ratingArrayList = restTemplate.getForObject("http://localhost:8083/ratings/users/76877c1e-932a-485f-8f8f-3ce2dfd71d48", ArrayList.class);
        logger.info("{}", ratingArrayList);
        user.setRatings(ratingArrayList);
        return user;
    }
}
