package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.entity.UserBasicInfo;
import web.service.UserBasicInfoService;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/13 15:34
 * @Description: 首页控制类
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private UserBasicInfoService userBasicInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        UserBasicInfo basicInfo = userBasicInfoService.selectUserByloginName("songbiaowei");
        System.out.println(basicInfo);
        return "index";
    }
}
