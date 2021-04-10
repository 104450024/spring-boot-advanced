package com.irm.springbootadvance.domain;

import org.springframework.data.jpa.repository.JpaRepository;


//定義找尋方法
public interface UserRepository extends JpaRepository<User,Long>
{
    User findByUsernameAndPassword(String username,String password);
}
