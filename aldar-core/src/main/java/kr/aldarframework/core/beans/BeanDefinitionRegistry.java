package kr.aldarframework.core.beans;

import java.util.Set;

/**
 * @author KingCjy
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(BeanDefinition beanDefinition);
    Set<BeanDefinition> getBeanDefinitions();
    BeanDefinition getBeanDefinition(Class<?> targetClass);
}
