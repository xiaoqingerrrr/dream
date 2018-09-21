参考文档：https://github.com/abel533/Mapper/wiki/2.2-mapping

branch-jsp-mybatis:
         1、整合jsp和mybatis
         2、单元测试test包里面有个测试类 测试了数据库查询
         3、整合tk-mybatis 简化基础mapper开发 
         4、整合代码生成器MBG  
            在generatorConfig.xml里面配置tableName 
            然后打开idea的Terminal执行
            mvn mybatis-generator:generate就会生成实体类和mapper,mapperxml
         5、配置pagehelper分页 pagehelper版本用的是4.1.6 用最新版本有报错 需要注意   
         
         
环境：jdk1.8 + spring5.0 + tomcat7 工具：IDEA
         
