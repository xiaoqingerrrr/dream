package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/13 15:26
 * @Description: web上下文之 dispatcherServlet 上下文
 */
// 配置类注解
@Configuration
// basePackages会扫描当前包下的所有文件 可以多个包 { "web", "web1"} 必须要有大括号 不然无法加载
@ComponentScan(basePackages = {"web"})
// 实现 WebMvcConfigurer 是为了配置 静态资源的处理
public class WebConfig {

}
