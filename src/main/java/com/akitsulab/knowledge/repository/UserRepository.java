package com.akitsulab.knowledge.repository;

import com.akitsulab.knowledge.domain.User;
import com.akitsulab.knowledge.domain.UserSelector;

import java.util.List;

/**
 * Userドメインオブジェクトをデータストアに格納、検索するモジュールを表すインターフェース。
 */

public interface UserRepository {

    /**
     * クエリパラメータによる複数県参照処理。
     *
     * @param selector 検索条件
     * @return 条件に合致したUserデータリスト
     */
    List<User> findList(UserSelector selector);

    /**
     * ID指定による1件参照処理。
     *
     * @param id リクエスト時のパスに含まれるID
     * @return 指定されたIDのUserデータ
     */
    User findOne(Long id);

    /**
     * Userの新規登録処理。
     *
     * @param user 登録内容
     */
    void insert(User user);

    /**
     * Userの1件更新処理。
     *
     * @param user 更新内容
     */
    void update(User user);

    /**
     * ID指定による1件削除処理。
     *
     * @param user 削除内容
     */
    void delete(User user);
}
