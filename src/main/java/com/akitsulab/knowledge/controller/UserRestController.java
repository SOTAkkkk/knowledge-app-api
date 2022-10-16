package com.akitsulab.knowledge.controller;

import com.akitsulab.knowledge.domain.User;
import com.akitsulab.knowledge.domain.UserList;
import com.akitsulab.knowledge.domain.UserSelector;
import com.akitsulab.knowledge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Userに関する操作を行うRestful Web APIのコントローラー実装。
 */
@RestController
@RequestMapping("services/v1/users")
public class UserRestController {
    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    private final UserService service;

    public UserRestController(UserService service) {
        this.service = service;
    }

    /**
     * クエリパラメータによる複数件参照処理。
     *
     * @param selector クエリパラメータの「email」の値を格納するUserSelector
     * @return 条件に合致したUserデータリスト
     */
    @GetMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserList find(UserSelector selector){return this.service.find(selector);}

    /**
     * ID指定による1件参照処理。
     *
     * @param userId リクエスト時のパスに含まれるID
     * @return 指定されたIDのUserデータ
     */
    @GetMapping(path = "/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable Long userId){return this.service.get(userId);}
}
