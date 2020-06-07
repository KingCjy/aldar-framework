package kr.aldarframework.core.beans;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
public class MethodBeanDefinitionTest {

    @Test
    public void initTest() throws NoSuchMethodException {
        MethodBeanDefinition methodBeanDefinition = MethodBeanDefinition.fromMethod(MethodBeanDefinitionTest.class.getMethod("messageBean"));

        assertThat(methodBeanDefinition.getType()).isEqualTo(String.class);
        assertThat(methodBeanDefinition.getName()).isEqualTo(String.class.getName());
    }

    public String messageBean() {
        return "Hello World";
    }
}
