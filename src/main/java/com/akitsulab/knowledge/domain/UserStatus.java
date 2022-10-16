package com.akitsulab.knowledge.domain;

public enum UserStatus {
    /**
     * ユーザ登録のみをした状態
     * まだ、仮パスワードを使用してログインし、パスワードを変更していない状態
     */
    CREATED,

    /**
     * パスワードを初期化した状態
     */
    INITIALIZED,

    /**
     * ユーザ登録後あるいはパスワードを初期化後、
     * 仮パスワードを使用してログインし、パスワードを変更した状態
     */
    SIGNEDUP
}
