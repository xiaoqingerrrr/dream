import config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import web.config.WebConfig;
import web.dao.RolesMapper;
import web.dao.UserBasicInfoMapper;
import web.entity.Roles;
import web.entity.UserBasicInfo;
import web.service.UserBasicInfoService;

import java.util.List;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/14 15:57
 * @Description:
 */
// 在spring环境运行
@RunWith(SpringJUnit4ClassRunner.class)
// spring-test包下的 加载指定的Configuration注解类，可以是类也可以是xml文件;给WebConfig配置类 加载到 spring环境中
@ContextConfiguration(classes = RootConfig.class, loader=AnnotationConfigContextLoader.class)
public class UserBasicInfoTest {

    // RootConfig配置类里面扫描了 所有的mapper 所以给mapper注入进来   如果这里是service就会报错
    @Autowired
    private UserBasicInfoMapper userBasicInfoMapper;

    @Autowired
    private RolesMapper rolesMapper;

    @Test
    public void testSelect() {
        UserBasicInfo basicInfo = userBasicInfoMapper.selectUserByloginName("songbiaowei");
        System.out.println(basicInfo);
    }

    // 测试tk.mybatis的方法
    @Test
    public void testTkMybatis() {
        List<Roles> rolesList = rolesMapper.selectAll();
        System.out.println(rolesList.size());
    }
}
