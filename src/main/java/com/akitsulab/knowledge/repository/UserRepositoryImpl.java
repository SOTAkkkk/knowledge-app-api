package com.akitsulab.knowledge.repository;

import com.akitsulab.knowledge.domain.User;
import com.akitsulab.knowledge.domain.UserSelector;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    private final SqlSession sqlSession;

    public UserRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<User> findList(UserSelector selector) {
//        return this.sqlSession.getMapper(UserMapper.class).find(selector);
        return null;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
