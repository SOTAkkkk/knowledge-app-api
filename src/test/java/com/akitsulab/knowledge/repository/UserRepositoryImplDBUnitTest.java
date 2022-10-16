package com.akitsulab.knowledge.repository;

import com.akitsulab.knowledge.KnowledgeApplication;
import com.akitsulab.knowledge.domain.User;
import com.akitsulab.knowledge.domain.UserSelector;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryImplDBUnitTest {
    /**
     * SELECTを検証するテスト
     */
    @SpringBootTest(classes = KnowledgeApplication.class)
    @TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbTestExecutionListener.class})
    @Nested
    public class FindDbTest {
        @Autowired
        private UserRepository target;

        @Test
        public void testFindAll() {
            List<User> users = target.findList(new UserSelector());
            assertEquals(1, users.size());
        }
    }

    static class DbTestExecutionListener extends AbstractTestExecutionListener {

    }
}
