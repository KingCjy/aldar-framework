package kr.aldarframework.core.beans;

import kr.aldarframework.core.annotation.Bean;
import kr.aldarframework.core.annotation.Configuration;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */

@Configuration
public class MethodBeanDefinitionReaderTest {

    @Test
    public void readMethodTest() throws NoSuchMethodException {
        BeanDefinitionRegistry registry = new DefaultBeanFactory();
        MethodBeanDefinitionReader reader = new MethodBeanDefinitionReader(registry);
        reader.register("kr.aldarframework.core.beans");

        assertThat(registry.getBeanDefinitions()).contains(MethodBeanDefinition.fromMethod(MethodBeanDefinitionReaderTest.class.getMethod("age")));
    }

    @Bean
    public Integer age() {
        return 22;
    }
}
