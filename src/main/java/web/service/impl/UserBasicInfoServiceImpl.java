package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserBasicInfoMapper;
import web.entity.UserBasicInfo;
import web.service.UserBasicInfoService;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/14 15:54
 * @Description:
 */

@Service("userService")
public class UserBasicInfoServiceImpl implements UserBasicInfoService {

    @Autowired
    private UserBasicInfoMapper userBasicInfoMapper;

    @Override
    public UserBasicInfo selectUserByloginName(String loginName) {
        UserBasicInfo userBasicInfo = userBasicInfoMapper.selectUserByloginName(loginName);
        return userBasicInfo;
    }
}
