package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="user")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class User {
    @Id
    @Column(name="User_ID")
    private int User_ID;
    public int getUser_ID(){return User_ID;}
    public void setUser_ID(int user_id){this.User_ID=user_id;}

    private String User_Name;
    private String Password;
    private String Phone;
    private String Email;
    private Boolean Role;

    public User() {}

    public User(String username, String password, String email, Boolean role,  String phone) {
        this.User_Name = username;
        this.Password = password;
        this.Email = email;
        this.Role = role;
        this.Phone = phone;

    }


    @Basic
    @Column(name="UserName")
    public String getUserName(){return User_Name;}
    public void setUserName(String user_Name){this.User_Name=user_Name;}

    @Basic
    @Column(name="Password")
    public String getPassword(){return Password;}
    public void setPassword(String password){this.Password=password;}

    @Basic
    @Column(name="Email")
    public String getEmail(){return Email;}
    public void setEmail(String email){this.Email=email;}

    @Basic
    @Column(name="Phone")
    public String getPhone(){return Phone;}
    public void setPhone(String phone){this.Phone=phone;}

    @Basic
    @Column(name="Role")
    public Boolean getRole(){return Role;}
    public void  setRole(Boolean role){this.Role = role;}

}
