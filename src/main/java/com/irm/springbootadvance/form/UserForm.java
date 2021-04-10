package com.irm.springbootadvance.form;

import com.irm.springbootadvance.domain.User;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.Normalizer;

public class UserForm {

  /*  public static final String PHONE_REG="'55'";*/

    @NotBlank
    private String username;
    @NotBlank
    @Length(min = 6)
    private String password;
/*    @Pattern(regexp = PHONE_REG,message = "請輸入正確手機號")*/
    @NotBlank
    private String phone;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String confirmPassword;


    public UserForm()
    {

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    public boolean confirmPassword()
    {
        if (this.password.equals(this.confirmPassword))
        {
            return true;
        }
        return false;
    }

    public User convertToUser()
    {
        User user=new UserFormConvert().convert(this);
        return user;

    }

    private class UserFormConvert implements FormConvert<UserForm,User>
   {

       @Override
       public User convert(UserForm userForm)
       {
           User user=new User();
           BeanUtils.copyProperties(userForm,user); //UserForm 複製該屬性至 User
           return user;
       }
   }

}
