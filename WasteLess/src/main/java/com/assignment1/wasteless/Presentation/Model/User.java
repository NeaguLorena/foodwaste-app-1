package com.assignment1.wasteless.Presentation.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "ID")
    private Long userId;
    @Column(name = "USER_NAME")
    private String userName;
    //@JsonIgnore
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "GROCERY_LIST_ID")
    private String groceryListId;
    @Column(name = "CREATED_TIME")
    @Temporal(value = TemporalType.DATE)
    private Date creationTime;
    @Column(name = "DOB")
    private Date dateofBirth;
    @Enumerated(value = EnumType.STRING)
    @Transient
    private String dateOfBirthString;

    public User() {
    }

    public User(String userName, String password, String groceryListId, Date creationTime, Date dateofBirth, String dateOfBirthString) {
        this.userName = userName;
        this.password = password;
        this.groceryListId = groceryListId;
        this.creationTime = creationTime;
        this.dateofBirth = dateofBirth;
        this.dateOfBirthString = dateOfBirthString;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(String groceryListId) {
        this.groceryListId = groceryListId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getDateOfBirthString() {
        return dateOfBirthString;
    }

    public void setDateOfBirthString(String dateOfBirthString) {
        this.dateOfBirthString = dateOfBirthString;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", creationTime=" + creationTime +
                ", dateofBirth=" + dateofBirth +
                ", dateOfBirthString='" + dateOfBirthString + '\'' +
                '}';
    }
}