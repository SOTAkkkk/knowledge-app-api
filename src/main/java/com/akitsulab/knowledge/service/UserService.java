package com.akitsulab.knowledge.service;

import com.akitsulab.knowledge.domain.User;
import com.akitsulab.knowledge.domain.UserList;
import com.akitsulab.knowledge.domain.UserSelector;

/**
 * Userドメインオブジェクトに関する処理を行うモジュールを表すインターフェース。
 */
public interface UserService {
    /**
     * クエリパラメータによる複数件参照処理。
     *
     * @param selector 検索条件
     * @return 条件に合致したUserデータリスト
     */
    UserList find(UserSelector selector);

    /**
     * Id指定による1件参照処理。
     *
     * @param id リクエスト時のパスに含まれるID
     * @return 指定されたIDのUserデータ
     */
    User get(Long id);

    /**
     * Userの新規登録処理。
     *
     * @param user 登録内容
     */
    void add(User user);

    /**
     * ID指定による1件更新処理。
     * @param user 更新内容
     */
    void set(User user);

    /**
     * ID指定による1件削除処理。
     *
     * @param id リクエスト時のパスに含まれるID
     */
    void remove(Long id);
}
