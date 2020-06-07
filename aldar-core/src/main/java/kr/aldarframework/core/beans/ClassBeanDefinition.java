package kr.aldarframework.core.beans;

import java.util.Objects;

/**
 * @author KingCjy
 */
public class ClassBeanDefinition implements BeanDefinition {

    private String name;
    private Class<?> type;

    private ClassBeanDefinition(Class<?> type) {
        this.name = type.getName();
        this.type = type;
    }

    public static ClassBeanDefinition fromType(Class<?> type) {
        return new ClassBeanDefinition(type);
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
        ClassBeanDefinition that = (ClassBeanDefinition) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}