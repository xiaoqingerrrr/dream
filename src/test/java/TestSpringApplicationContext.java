import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import web.config.WebConfig;
import web.controller.IndexController;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/13 17:18
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
// spring-test包下的 加载指定的Configuration注解类，可以是类也可以是xml文件;给WebConfig配置类 加载到 spring环境中
// 只有在spring环境中拥有WebConfig 才可以使用 new AnnotationConfigApplicationContext(WebConfig.class);否则会报错
@ContextConfiguration(classes = WebConfig.class, loader=AnnotationConfigContextLoader.class)
public class TestSpringApplicationContext {

    @Test
    public void testSelect() {
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        // 如果有多个IndexController 需要在@Controller注解中指定 例子：@Controller("IndexController1")
        IndexController controller = (IndexController) context.getBean("indexController");
        String index = controller.index();
        System.out.println(index);
    }
}

