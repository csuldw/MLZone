package com.mlzone.csuldw.entity;

/**
 * 
 * Date: 2017年10月14日 下午11:01:17 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public class UserEntity {
    private Integer id;

    private String username;

    private String nickname;

    private String password;

    private Integer sex;

    private String idCard;

    private String birthday;

    private String phoneNumber;

    private String address;

    private String email;

    private String status;

    private String image;

    private Integer userType;

    private Integer accountSource;

    private String regDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getAccountSource() {
        return accountSource;
    }

    public void setAccountSource(Integer accountSource) {
        this.accountSource = accountSource;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate == null ? null : regDate.trim();
    }

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username
				+ ", nickname=" + nickname + ", password=" + password
				+ ", sex=" + sex + ", idCard=" + idCard + ", birthday="
				+ birthday + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", email=" + email + ", status=" + status
				+ ", image=" + image + ", userType=" + userType
				+ ", accountSource=" + accountSource + ", regDate=" + regDate
				+ "]";
	}
}