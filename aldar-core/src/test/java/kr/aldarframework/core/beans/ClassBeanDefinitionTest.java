package kr.aldarframework.core.beans;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
public class ClassBeanDefinitionTest {

    @Test
    public void initTest() {
        ClassBeanDefinition classBeanDefinition = ClassBeanDefinition.fromType(TestClass.class);

        assertThat(classBeanDefinition.getName()).isEqualTo(TestClass.class.getName());
        assertThat(classBeanDefinition.getType()).isEqualTo(TestClass.class);
    }

    static class TestClass {

    }
}
