package com.nap.up.repository;

import com.nap.up.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @creator napuping
 * @createTime 2020/3/8
 * @description
 */
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

}
