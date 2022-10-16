package com.akitsulab.knowledge.repository;

import com.akitsulab.knowledge.KnowledgeApplication;
import com.akitsulab.knowledge.domain.User;
import com.akitsulab.knowledge.domain.UserSelector;
import com.akitsulab.knowledge.domain.UserStatus;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
            assertEquals(2, users.size());
        }

        @Test
        public void testFindFilteredByMail() {
            UserSelector input = new UserSelector();
            input.setEmail("test6@yahoo.xx.xx");
            List<User> users = target.findList(input);
            assertEquals(1, users.size());
            assertEquals("test6@yahoo.xx.xx", users.get(0).getEmail());
        }

        @Test
        public void testFindOne() {
            User user = target.findOne(1L);
            assertNotNull(user);
            assertEquals(1L, user.getUserId());
            assertEquals("ユーザ1", user.getFirstName());
            assertEquals("管理者", user.getLastName());
        }

        @Test
        public void testGetException() {
            assertThrows(ResourceNotFoundException.class, () -> target.findOne(7L));
        }
    }

    @SpringBootTest(classes = KnowledgeApplication.class)
    @TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbTestExecutionListener.class})
    @Nested
    public class InsertDbTest {
        @Autowired
        private UserRepository target;

        @Test
        public void testInsert() {
            User user = new User();
            user.setPassword("pqr");
            user.setEmail("test6@yahoo.xx.xx");
            user.setAdministratorFlag(false);
            user.setFirstName("テスト6");
            user.setLastName("ユーザー6");
            user.setStatus(UserStatus.CREATED);
            target.insert(user);
        }
    }

    /**
     * UPDATEのSQLを検証するテスト
     */
    @SpringBootTest(classes = KnowledgeApplication.class)
    @TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbTestExecutionListener.class})
    @Nested
    public class UpdateDbTest {
        @Autowired
        private UserRepository target;

        @Test
        public void testUpdate() {
            User user = target.findOne(1L);
            user.setEmail("test5update@yahoo.xx.xx");   // メールアドレスと更新
            target.update(user);
        }
    }

    static class DbTestExecutionListener extends AbstractTestExecutionListener {

    }
}
