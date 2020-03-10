package com.nap.up.repository;

import com.nap.up.entity.PdUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @creator napuping
 * @createTime 2020/3/8
 * @description
 */
public interface PdUserRepository extends JpaRepository<PdUser, String>, JpaSpecificationExecutor<PdUser> {
}
