package kr.aldarframework.core.beans;

import kr.aldarframework.core.annotation.Component;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
@Component
public class ClassPathDefinitionScannerTest {

    @Test
    public void scanClassTest() {
        BeanDefinitionRegistry registry = new DefaultBeanFactory();
        ClassPathDefinitionScanner classPathDefinitionScanner = new ClassPathDefinitionScanner(registry);
        classPathDefinitionScanner.scan("kr.aldarframework.core.beans");

        assertThat(registry.getBeanDefinitions()).contains(ClassBeanDefinition.fromType(ClassPathDefinitionScannerTest.class));
    }
}
