package com.akitsulab.knowledge.repository.mybatis;

import com.akitsulab.knowledge.domain.User;
import com.akitsulab.knowledge.domain.UserSelector;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatisによるUserテーブルとのマッパーを表すインターフェース。
 */

@Mapper
public interface UserMapper {
    List<User> find(UserSelector selector);

    User get(@Param("userId") Long userId);

    int add(User user);

    int set(User user);

    int remove(User user);
}
