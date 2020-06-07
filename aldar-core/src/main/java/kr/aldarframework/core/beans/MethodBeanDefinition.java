package kr.aldarframework.core.beans;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author KingCjy
 */
public class MethodBeanDefinition implements BeanDefinition {

    private Class<?> type;
    private Method method;
    private String name;

    private MethodBeanDefinition(Method method) {
        this.type = method.getReturnType();
        this.method = method;
        this.name = type.getName();
    }

    public static MethodBeanDefinition fromMethod(Method method) {
        return new MethodBeanDefinition(method);
    }

    @Override
    public Class<?> getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodBeanDefinition that = (MethodBeanDefinition) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(method, that.method) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, method, name);
    }
}
