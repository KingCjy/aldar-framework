package kr.aldarframework.core.beans;

import kr.aldarframework.core.annotation.Component;
import kr.aldarframework.core.util.AldarReflectionUtils;

import java.util.Set;

/**
 * @author KingCjy
 */
public class ClassPathDefinitionScanner {

    private BeanDefinitionRegistry beanDefinitionRegistry;

    public ClassPathDefinitionScanner(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void scan(String basePackage) {
        Set<Class> classes = AldarReflectionUtils.findAnnotatedClasses(basePackage, Component.class);

        for (Class targetClass : classes) {
            beanDefinitionRegistry.registerBeanDefinition(ClassBeanDefinition.fromType(targetClass));
        }
    }
}
