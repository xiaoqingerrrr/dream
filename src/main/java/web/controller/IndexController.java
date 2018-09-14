package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/13 15:34
 * @Description: 首页控制类
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
