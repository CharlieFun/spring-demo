package com.funstar.springdemo.feign.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

@Service
public class FeignBeanFactoryPostProcessor implements BeanFactoryPostProcessor, ResourceLoaderAware {

    private static final String CLASS_RESOURCE_PATTERN = "**/*.class";

    private String feignType = MyFeign.class.getTypeName();

    private ResourcePatternResolver resourcePatternResolver;

    private MetadataReaderFactory metadataReaderFactory;


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                ClassUtils.convertClassNameToResourcePath("com.funstar.springdemo") +
                "/" + CLASS_RESOURCE_PATTERN;

        try {
            Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);

            for (Resource resource : resources) {
                if (!resource.isReadable()) {
                    continue;
                }

                MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                if (null == metadataReader || null == metadataReader.getAnnotationMetadata() || null == metadataReader.getAnnotationMetadata().getAnnotationTypes()) {
                    continue;
                }

                for (String type : metadataReader.getAnnotationMetadata().getAnnotationTypes()) {
                    if (feignType.equals(type)) {
                        registerBeanDefinition((DefaultListableBeanFactory) configurableListableBeanFactory, metadataReader.getAnnotationMetadata().getClassName());
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("init feign fail", e);
        }
    }

    private void registerBeanDefinition(DefaultListableBeanFactory beanFactory, String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        MyFeign feign = (MyFeign) clazz.getAnnotation(MyFeign.class);
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(FeignFactoryBean.class);
        beanDefinitionBuilder.addPropertyValue("type", clazz);
        beanDefinitionBuilder.addPropertyValue("host", feign.host());
        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
        beanFactory.registerBeanDefinition(clazz.getSimpleName(), beanDefinition);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        this.metadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);
    }
}
