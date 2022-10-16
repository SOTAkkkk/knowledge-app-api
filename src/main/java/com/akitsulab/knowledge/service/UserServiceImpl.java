package com.akitsulab.knowledge.service;

import com.akitsulab.knowledge.domain.User;
import com.akitsulab.knowledge.domain.UserList;
import com.akitsulab.knowledge.domain.UserSelector;
import com.akitsulab.knowledge.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserList find(UserSelector selector) {
        UserList userList = new UserList();
        userList.setUsers(this.userRepository.findList(selector));
        return userList;
    }

    @Override
    public User get(Long userId) {
        return this.userRepository.findOne(userId);
    }
}
