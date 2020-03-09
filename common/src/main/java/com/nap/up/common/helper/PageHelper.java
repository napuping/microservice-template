package com.nap.up.common.helper;

import com.github.pagehelper.PageInfo;
import com.nap.up.common.standard.jpa.JpaCondition;
import com.nap.up.common.standard.jpa.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.Function;

/**
 * @creator napuping
 * @createTime 2020/3/9
 * @description
 */
public class PageHelper extends com.github.pagehelper.PageHelper {

    //针对jpa的分页查询
    public static <T> PageInfo<T> jpaStart(int pageNum, int pageSize, JpaRepository jpaRepository, JpaCondition condition) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<T> page = jpaRepository.findAll(new Specification() {
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = condition.build(root, criteriaBuilder);
                Predicate[] p = new Predicate[predicates.size()];
                query.where(predicates.toArray(p));
                return null;
            }
        }, pageable);
        PageInfo<T> pageInfo = new PageInfo<>(page.getContent());
        copyPageInfo(page, pageInfo);
        return pageInfo;
    }
    //copy page to pageInfo
    private static void copyPageInfo(Page page, PageInfo pageInfo) {
        pageInfo.setPageNum(page.getNumber() + 1);
        pageInfo.setPageSize(page.getSize());
        pageInfo.setHasNextPage(page.hasNext());
        pageInfo.setPages(page.getTotalPages());
        pageInfo.setHasPreviousPage(page.hasPrevious());
        pageInfo.setIsFirstPage(page.isFirst());
        pageInfo.setIsLastPage(page.isLast());
        pageInfo.setTotal(page.getTotalElements());
    }
}
