package com.assignment1.wasteless;

import com.assignment1.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment1.wasteless.Data.Repository.GroceryListRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
import com.assignment1.wasteless.Presentation.Model.GroceryListItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class WastelessApplicationTests {

    @Autowired
    private GroceryListRepository groceryListRepository;
    @Autowired
    private GroceryListItemRepository groceryListItemRepository;

//    @Test
//    @DisplayName("Create User Test ")
//    void createUserTest() {
//
//        User created = userRepository.save(getUser());
//
//        Assertions.assertTrue(created != null);
//    }
//
//
//    private User getUser() {
//
//        User user = new User();
//        user.setUserName("user");
//        user.setPassword("ABC123abc*");
//
//        return user;
//    }

    @Test
    @DisplayName("Create List Test ")
    void createListTest() {

        GroceryList created = groceryListRepository.save(getList());

        Assertions.assertTrue(created != null);
    }


    private GroceryList getList() {

        GroceryList list = new GroceryList( "user", "emergency list");

        return list;
    }

    @Test
    @DisplayName("Create Item Test ")
    void createItemTest() throws ParseException {

        GroceryListItem created = groceryListItemRepository.save(getItem());

        Assertions.assertTrue(created != null);
    }


    private GroceryListItem getItem() throws ParseException {

        Date purchaseDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-03");
        Date expirationDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-03");
        Date consumptionDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-03");

        GroceryListItem groceryListItem = new GroceryListItem( 1, "rosii", 10, 5, purchaseDate, expirationDate, consumptionDate);

        return groceryListItem;
    }

}
