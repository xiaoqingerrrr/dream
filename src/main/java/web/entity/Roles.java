package web.entity;

import javax.persistence.Id;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/18 18:28
 * @Description:
 */
public class Roles {
    @Id
    private Integer id;
    private String roleName;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
