package kr.aldarframework.core.beans;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
public class DefaultBeanFactoryTest {
    @Test
    public void instantiateTest() {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();

        beanFactory.registerBeanDefinition(ClassBeanDefinition.fromType(TestClass.class));
        beanFactory.instantiate();

        TestClass testClass = beanFactory.getBean(TestClass.class);

        assertThat(testClass.getMessage()).isEqualTo("helloWorld");
    }

    @Test
    public void instantiateWithDependencyInjectionTest() {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();

        beanFactory.registerBeanDefinition(ClassBeanDefinition.fromType(TestClass.class));
        beanFactory.registerBeanDefinition(ClassBeanDefinition.fromType(TestClass2.class));
        beanFactory.instantiate();

        TestClass testClass = beanFactory.getBean(TestClass.class);
        TestClass2 testClass2 = beanFactory.getBean(TestClass2.class);

        assertThat(testClass.getMessage()).isEqualTo("helloWorld");
        assertThat(testClass2.getMessage()).isEqualTo("helloWorld");
    }

    static class TestClass {
        private String message = "helloWorld";

        public String getMessage() {
            return message;
        }
    }

    static class TestClass2 {
        private final TestClass testClass;

        public TestClass2(TestClass testClass) {
            this.testClass = testClass;
        }

        public String getMessage() {
            return testClass.getMessage();
        }
    }
}
