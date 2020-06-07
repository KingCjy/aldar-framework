package kr.aldarframework.core.beans;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author KingCjy
 */
public class BeanUtilsTest {

    @Test
    public void instantiateClassTest() throws Exception {
        String message = "Hello World";
        TestClass testClass = BeanUtils.instantiateClass(TestClass.class.getDeclaredConstructor(String.class), message);
        assertThat(testClass.getMessage()).isEqualTo(message);
    }

    @Test
    public void instantiateInterfaceTest() {
        assertThatThrownBy( () -> {
            BeanUtils.instantiateClass(List.class);
        }).isInstanceOf(BeanInstantiationException.class);
    }

    static class TestClass {

        private final String message;

        public TestClass(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
