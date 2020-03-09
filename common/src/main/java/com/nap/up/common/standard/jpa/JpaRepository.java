package com.nap.up.common.standard.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.function.Predicate;

/**
 * @creator napuping
 * @createTime 2020/3/9
 * @description
 */
@NoRepositoryBean
public interface JpaRepository<T, ID> extends org.springframework.data.jpa.repository.JpaRepository<T, ID> {

    Page<T> findAll(Specification<T> specification, Pageable pageable);

}
