package com.dataart.edu.springripper.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProfilingAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class<?>> map = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(Profiling.class)){
            map.put(beanName, bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = map.get(beanName);
        if(beanClass != null){
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                System.out.println("Profiling...");
                long before = System.nanoTime();
                Object result = method.invoke(bean, args);
                long after = System.nanoTime();
                System.out.println(after - before);
                System.out.println("That's all");
                return result;
            });
        }
        return bean;
    }
}
