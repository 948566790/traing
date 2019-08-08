package oldtraining.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String uname;
    private String pwd;
    private String age;
    private String sex;
    private String tel;
    private String email;
    private String[] fav;
    private String sign;
    private Map<String, String> message = new HashMap<String, String>();

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getFav() {
        return fav;
    }

    public void setFav(String[] fav) {
        this.fav = fav;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                ", fav=" + Arrays.toString(fav) +
                ", sign='" + sign + '\'' +
                ", msg='" + message + '\'' +
                '}';
    }

    public User(String uname, String pwd, String age, String sex, String tel, String email, String[] fav, String sign) {
        this.uname = uname;
        this.pwd = pwd;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
        this.email = email;
        this.fav = fav;
        this.sign = sign;
    }

    public Map<String, String> getMessage() {
        return message;
    }
}
