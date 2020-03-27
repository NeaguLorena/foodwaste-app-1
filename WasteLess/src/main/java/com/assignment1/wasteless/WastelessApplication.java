package com.assignment1.wasteless;

import com.assignment1.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment1.wasteless.Data.Repository.GroceryListRepository;
import com.assignment1.wasteless.Data.Repository.UserRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
import com.assignment1.wasteless.Presentation.Model.GroceryListItem;
import com.assignment1.wasteless.Presentation.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories
public class WastelessApplication {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroceryListRepository groceryListRepository;
    @Autowired
    private GroceryListItemRepository groceryListItemRepository;

    public static void main(String[] args) {
        SpringApplication.run(WastelessApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> initDb();
    }

    //@PostConstruct
    public void initDb() throws ParseException {
        User user = new User();
        user.setUserName("Lore");
        user.setPassword("abc");
        user.setDateofBirth(new Date());
        user.setCreationTime(new Date());
        userRepository.save(user);

        GroceryList list = new GroceryList((long) 1, "emergency list");
        groceryListRepository.save(list);

        Date purchaseDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-03");
        Date expirationDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-03");
        Date consumptionDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-03");

        GroceryListItem groceryListItem = new GroceryListItem((long) 1, "rosii", 10, 5, purchaseDate, expirationDate, consumptionDate);

        Date purchaseDate2 = new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-03");
        Date expirationDate2 = new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-03");
        Date consumptionDate2 = new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-03");

        GroceryListItem groceryListItem2 = new GroceryListItem((long) 1, "rosii", 10, 5, purchaseDate2, expirationDate2, consumptionDate2);

        groceryListItemRepository.save(groceryListItem);
        groceryListItemRepository.save(groceryListItem2);

    }
}
