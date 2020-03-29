package com.assignment1.wasteless;

import com.assignment1.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment1.wasteless.Data.Repository.GroceryListRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
import com.assignment1.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories
public class WastelessApplication {

    @Autowired
    private GroceryListRepository groceryListRepository;
    @Autowired
    private GroceryListItemRepository groceryListItemRepository;

    public static void main(String[] args) {
        SpringApplication.run(WastelessApplication.class, args);
    }

    @PostConstruct
    public void initDb() throws ParseException {

        GroceryList list = new GroceryList( "user", "emergency list");
        groceryListRepository.save(list);

        Date purchaseDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        Date expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        Date consumptionDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");

        GroceryListItem groceryListItem = new GroceryListItem( 1, "rosii", 10, 5, purchaseDate, expirationDate, consumptionDate);

        Date purchaseDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        Date expirationDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        Date consumptionDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");

        GroceryListItem groceryListItem2 = new GroceryListItem( 1, "rosii", 10, 5, purchaseDate2, expirationDate2, consumptionDate2);

        groceryListItemRepository.save(groceryListItem);
        groceryListItemRepository.save(groceryListItem2);

    }
}
