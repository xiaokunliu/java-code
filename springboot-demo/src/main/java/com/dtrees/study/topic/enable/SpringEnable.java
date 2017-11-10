package com.dtrees.study.topic.enable;

/**
 * Created by keithl on 2017/11/8.
 */

public class SpringEnable {

    // @Enable* 的工作原理

    // 直接导入配置类
    /**
     *
         @Target(ElementType.TYPE)
         @Retention(RetentionPolicy.RUNTIME)
         @Import(SchedulingConfiguration.class)
         @Documented
         public @interface EnableScheduling {}

         @Configuration     注解了配置@Configuration
         @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
         public class SchedulingConfiguration {
            // 注册ScheduledAnnotationBeanPostProcessor的Bean
             @Bean(name = TaskManagementConfigUtils.SCHEDULED_ANNOTATION_PROCESSOR_BEAN_NAME)
             @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
             public ScheduledAnnotationBeanPostProcessor scheduledAnnotationProcessor() {
             return new ScheduledAnnotationBeanPostProcessor();
             }

         }

     */

    // 依据条件选择配置类

    /**
     *
     @Target(ElementType.TYPE)
     @Retention(RetentionPolicy.RUNTIME)
     @Documented
     @Import(AsyncConfigurationSelector.class)
     public @interface EnableAsync {

        Class<? extends Annotation> annotation() default Annotation.class;

        boolean proxyTargetClass() default false;

        AdviceMode mode() default AdviceMode.PROXY;

        int order() default Ordered.LOWEST_PRECEDENCE;
     }


     public class AsyncConfigurationSelector extends AdviceModeImportSelector<EnableAsync> {

     private static final String ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME =
     "org.springframework.scheduling.aspectj.AspectJAsyncConfiguration";

     // 根据选择的模式来导入相关的配置信息
     @Override
     public String[] selectImports(AdviceMode adviceMode) {
            switch (adviceMode) {
             case PROXY:
                return new String[] { ProxyAsyncConfiguration.class.getName() };
             case ASPECTJ:
                return new String[] { ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME };
             default:
                return null;
             }
        }

     }
     */

    // 动态注册Bean

    /**
     * @Target(ElementType.TYPE)
     @Retention(RetentionPolicy.RUNTIME)
     @Documented
     @Import(AspectJAutoProxyRegistrar.class)
     public @interface EnableAspectJAutoProxy {

            boolean proxyTargetClass() default false;

            boolean exposeProxy() default false;

     }

     // ImportBeanDefinitionRegistrar:在运行时自动添加Bean到已有的配置类中
     class AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar {

             // AnnotationMetadata :获取当前配置类上的注解
             // BeanDefinitionRegistry:用来注册Bean
            @Override
            public void registerBeanDefinitions(
                    AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

                AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);


                AnnotationAttributes enableAspectJAutoProxy =
                        AnnotationConfigUtils.attributesFor(importingClassMetadata, EnableAspectJAutoProxy.class);
                if (enableAspectJAutoProxy.getBoolean("proxyTargetClass")) {
                    AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
                }
                if (enableAspectJAutoProxy.getBoolean("exposeProxy")) {
                    AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
                }
            }

        }


     */

}
