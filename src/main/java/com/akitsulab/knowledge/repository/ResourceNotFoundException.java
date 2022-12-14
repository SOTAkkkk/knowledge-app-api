package com.akitsulab.knowledge.repository;

/**
 * 検索、更新、削除対象のリソースが存在しないことを表すカスタム例外
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){super(message);}
    public ResourceNotFoundException(String message, Throwable cause){super(message, cause);}
}
