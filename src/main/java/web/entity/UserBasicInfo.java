package web.entity;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/14 15:46
 * @Description:
 */
public class UserBasicInfo {
    private Integer id;
    private String loginName;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
