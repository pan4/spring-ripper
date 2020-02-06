package com.dataart.edu.springripper.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedClassAnnotationBeanDefinitionPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            try {
                if(beanDefinition.getBeanClassName() == null) {
                    return;
                }

                Class<?> beanClass = Class.forName(beanDefinition.getBeanClassName());
                DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                if(annotation != null){
                    Class<?> newImple = annotation.newImple();
                    beanDefinition.setBeanClassName(newImple.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
