package web.service;

import web.entity.UserBasicInfo;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/14 15:52
 * @Description:
 */
public interface UserBasicInfoService {

    UserBasicInfo selectUserByloginName(String loginName);
}
