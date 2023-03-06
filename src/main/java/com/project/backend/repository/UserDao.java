package com.project.backend.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public UserDao() {
        System.out.println("RoleDao 생성자 호출");
    }
}
