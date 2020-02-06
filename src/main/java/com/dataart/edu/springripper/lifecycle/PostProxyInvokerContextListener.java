package com.dataart.edu.springripper.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class PostProxyInvokerContextListener {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String originalClassName = beanDefinition.getBeanClassName();
            if(originalClassName == null){
                continue;
            }
            try {
                Class<?> originalClass = Class.forName(originalClassName);
                Method[] methods = originalClass.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(PostProxy.class)) {
                        Object bean = applicationContext.getBean(name);
                        Method current = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                        current.invoke(bean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
