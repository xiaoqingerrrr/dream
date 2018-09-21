package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import web.quartz.JobTest;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/13 15:26
 * @Description: web上下文之 dispatcherServlet 上下文
 */
// 配置类注解
@Configuration
// 启用springMVC (具体作用目前就知道 让configureDefaultServletHandling 方法生效)
@EnableWebMvc
// basePackages会扫描当前包下的所有文件 可以多个包 { "web", "web1"} 必须要有大括号 不然无法加载
@ComponentScan(basePackages = {"web"})
// 实现 WebMvcConfigurer 是为了配置 静态资源的处理
public class WebConfig implements WebMvcConfigurer {

    // 配置jsp视图解析器
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    // 静态资源的处理 如果没有这个 页面就引用不到css js等静态文件
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 配置多个定时任务
    // 这个方法不够好 但是可以使用  不够好的地方是代码冗余
    @Bean
    public SchedulerFactoryBean startQuertz() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(myJobTrigger().getObject(), myJobTrigger1().getObject());
        return schedulerFactoryBean;
    }

    /**定时任务1 ----start*/
    @Bean
    public CronTriggerFactoryBean myJobTrigger() {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(myJobDetail().getObject());
        factoryBean.setCronExpression("0/10 * *  * * ?");
        return factoryBean;
    }

    @Bean
    public MethodInvokingJobDetailFactoryBean myJobDetail() {
        MethodInvokingJobDetailFactoryBean methodInvoke = new MethodInvokingJobDetailFactoryBean();
        methodInvoke.setTargetObject(checkStatus());
        methodInvoke.setTargetMethod("checkStatus");
        return methodInvoke;
    }

    @Bean
    public JobTest checkStatus() {
        return new JobTest();
    }
    /**定时任务1 ----end*/

    /**定时任务2 ----start*/
    @Bean
    public CronTriggerFactoryBean myJobTrigger1() {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(myJobDetail1().getObject());
        factoryBean.setCronExpression("0/10 * *  * * ?");
        return factoryBean;
    }

    @Bean
    public MethodInvokingJobDetailFactoryBean myJobDetail1() {
        MethodInvokingJobDetailFactoryBean methodInvoke = new MethodInvokingJobDetailFactoryBean();
        methodInvoke.setTargetObject(statis());
        methodInvoke.setTargetMethod("statis");
        return methodInvoke;
    }

    @Bean
    public JobTest statis() {
        return new JobTest();
    }
    /**定时任务2 ----end*/
}
