package com.nap.up.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @creator napuping
 * @createTime 2020/3/2
 * @description 全路径作为bean name
 */
public class BeanNameUnique extends AnnotationBeanNameGenerator {
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        return definition.getBeanClassName();
    }
}
