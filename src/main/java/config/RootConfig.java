package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/13 15:23
 * @Description: web上下文之 contextLoaderListener 上下文配置
 */
// 配置类注解
@Configuration
// basePackageClasses会扫描当前类所在包下的所有文件 可以多个配置 例子 { RootConfig.class, RootConfig1.class}
// 必须要有大括号 不然无法加载
@ComponentScan(basePackageClasses = { RootConfig.class })
public class RootConfig {
}
