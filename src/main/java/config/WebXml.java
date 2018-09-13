package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import web.config.WebConfig;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/13 15:16
 * @Description: WebXml 替代 web.xml
 */
public class WebXml extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ RootConfig.class };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ WebConfig.class };
    }

    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
