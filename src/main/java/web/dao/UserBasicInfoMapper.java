package web.dao;

import web.entity.UserBasicInfo;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/14 15:50
 * @Description:
 */
public interface UserBasicInfoMapper {
    UserBasicInfo selectUserByloginName(String loginName);
}
