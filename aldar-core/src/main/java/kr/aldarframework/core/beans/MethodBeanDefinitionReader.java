package kr.aldarframework.core.beans;

import kr.aldarframework.core.annotation.Bean;
import kr.aldarframework.core.annotation.Component;
import kr.aldarframework.core.annotation.Configuration;
import kr.aldarframework.core.util.AldarReflectionUtils;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author KingCjy
 */
public class MethodBeanDefinitionReader {
    private BeanDefinitionRegistry beanDefinitionRegistry;

    public MethodBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void register(String basePackage) {
        Set<Class> classes = AldarReflectionUtils.findAnnotatedClasses(basePackage, Component.class, Configuration.class);

        for (Class<?> targetClass : classes) {
            findBeanRegisterMethods(targetClass);
        }
    }

    private void findBeanRegisterMethods(Class<?> targetClass) {
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            registerAnnotationBeanDefinition(targetClass, method);
        }
    }

    private void registerAnnotationBeanDefinition(Class<?> targetClass, Method method) {
        if(method.isAnnotationPresent(Bean.class)) {
            beanDefinitionRegistry.registerBeanDefinition(MethodBeanDefinition.fromMethod(method));
        }
    }
}
