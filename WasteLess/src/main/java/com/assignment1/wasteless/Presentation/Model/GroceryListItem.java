package com.assignment1.wasteless.Presentation.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "ITEM")
public class GroceryListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long itemId;
    private Long listId;
    private String name;
    private int quantity;
    private int calorieValue;
    private Date purchaseDate;
    private Date expirationDate;
    private Date consumptionDate;

    public GroceryListItem() {
    }

    public GroceryListItem(Long listId, String name, int quantity, int calorieValue, Date purchaseDate, Date expirationDate, Date consumptionDate) {
        this.listId = listId;
        this.name = name;
        this.quantity = quantity;
        this.calorieValue = calorieValue;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalorieValue() {
        return calorieValue;
    }

    public void setCalorieValue(int calorieValue) {
        this.calorieValue = calorieValue;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    @Override
    public String toString() {
        return "GroceryListItem{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", calorieValue=" + calorieValue +
                ", purchaseDate=" + purchaseDate +
                ", expirationDate=" + expirationDate +
                ", consumptionDate=" + consumptionDate +
                '}';
    }
}
