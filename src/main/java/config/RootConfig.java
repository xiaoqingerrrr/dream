package config;

import com.github.pagehelper.PageHelper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

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

    // 配置数据库连接池
    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        // serverTimezone配置时区  不配置启动的时候会报错
        dataSource.setUrl("jdbc:mysql://localhost:3306/study_demo?serverTimezone=GMT");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //1、池启动时创建的连接数量
        dataSource.setInitialSize(3);
        //2、低版本的包 叫maxActive 同一时间可从池中分配的最多连接数。如果设置为 0 ，表示无限制
        dataSource.setMaxTotal(5);
        //3、同一时间可从池中分配的最多连接数。如果设置为 0 ，表示无限制
        dataSource.setMaxIdle(3);
        //4、在不创建新连接的情况下，池中保持空闲的最小连接数
        dataSource.setMinIdle(1);
        //5、在抛出异常之前，池等待连接回收的最大时间（当没有可用连接时）。如果设置为 -1 ，表示无限等待
        dataSource.setMaxWaitMillis(2000);
        /**这几个不知道什么意思
            dataSource.setMinEvictableIdleTimeMillis(); // 连接在池中保持空闲而不被回收的最大时间
            dataSource.setPoolPreparedStatements(); // 是否对预处理语句（ prepared statement ）进行池管理（布尔值）
            dataSource.setMaxOpenPreparedStatements();// 在同一时间能够从语句池中分配的预处理语句（ prepared statement ）的最大数量。如果设置为 0 ，表示无限制
        */
        return dataSource;
    }

    // 配置SqlSessionFactoryBean
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        // 配置数据库表对应的java实体类
        sqlSessionFactory.setTypeAliasesPackage("web.entity");
        // 配置mapper的扫描，找到所有的mapper.xml映射文件 必须在resource目录下
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources("classpath:mapper/*.xml");
            sqlSessionFactory.setMapperLocations(resources);
            Interceptor[] arrInterceptor = new Interceptor[1];
            Interceptor pageInterceptor = new PageHelper();
            Properties properties = new Properties();
            properties.put("dialect", "mysql");
            properties.put("reasonable", true);
            pageInterceptor.setProperties(properties);
            arrInterceptor[0] = pageInterceptor;
            sqlSessionFactory.setPlugins(arrInterceptor);
            return sqlSessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 作用是扫描dao
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("web.dao");
        msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return msc;
    }
}
