package com.akitsulab.knowledge.repository;

import com.akitsulab.knowledge.domain.User;
import com.akitsulab.knowledge.domain.UserSelector;
import com.akitsulab.knowledge.repository.mybatis.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryImplTest {
    @Mock
    private SqlSession sqlSession;

    @Mock
    private UserMapper mapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        Mockito.doReturn(mapper).when(sqlSession).getMapper(UserMapper.class);
    }

    @AfterEach
    public void after() {
        Mockito.verify(sqlSession, Mockito.times(1)).getMapper(UserMapper.class);
    }

    @Test
    public void testFindList(){
        // setup:
        List<User> findResult = new ArrayList<>();
        User user = new User();
        findResult.add(user);
        UserSelector selector = new UserSelector();
        Mockito.doReturn(findResult).when(mapper).find(selector);
        // when:
        List<User> result = new UserRepositoryImpl(this.sqlSession).findList(selector);
        // then:
        assertEquals(findResult, result);
        Mockito.verify(mapper, Mockito.times(1)).find(selector);
    }

}
