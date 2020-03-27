package com.assignment1.wasteless.Presentation.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "LIST")
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long listId;
    private Long userId;
    private String listName;

    public GroceryList() {
    }

    public GroceryList(Long userId, String listName) {
        this.userId = userId;
        this.listName = listName;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "listId=" + listId +
                ", userId=" + userId +
                ", listName='" + listName + '\'' +
                '}';
    }
}
