package web.entity;

import javax.persistence.*;

@Table(name = "user_detail")
public class UserDetail {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * 生日
     */
    @Column(name = "birth_day")
    private String birthDay;

    /**
     * 身份证
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 银行卡号
     */
    @Column(name = "bank_no")
    private String bankNo;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取生日
     *
     * @return birth_day - 生日
     */
    public String getBirthDay() {
        return birthDay;
    }

    /**
     * 设置生日
     *
     * @param birthDay 生日
     */
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * 获取身份证
     *
     * @return id_card - 身份证
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证
     *
     * @param idCard 身份证
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取银行卡号
     *
     * @return bank_no - 银行卡号
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 设置银行卡号
     *
     * @param bankNo 银行卡号
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }
}