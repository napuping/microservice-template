package com.nap.up.common.standard.jpa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @creator napuping
 * @createTime 2020/3/9
 * @description
 */
public interface JpaCondition {

    List<Predicate> build(Root root, CriteriaBuilder cb);

}
