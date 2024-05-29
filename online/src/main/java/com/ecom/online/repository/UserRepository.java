package com.ecom.online.repository;

import com.ecom.online.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity ,Long> {

    UserEntity findByUserName(String username);

    UserEntity findByEmail(String email);

    UserEntity findByUserNameAndPassword(String username,String password);

}
