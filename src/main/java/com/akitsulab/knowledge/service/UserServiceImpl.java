package com.akitsulab.knowledge.service;

import com.akitsulab.knowledge.domain.User;
import com.akitsulab.knowledge.domain.UserList;
import com.akitsulab.knowledge.domain.UserSelector;
import com.akitsulab.knowledge.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

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

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void add(User user) {
        this.userRepository.insert(user);
    }

}
