package com.assignment1.wasteless.Bussiness.Service;

import com.assignment1.wasteless.Data.Repository.GroceryListRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryListService {

    GroceryListRepository groceryListRepository;

//    public void save(GroceryList groceryList) {
////        String sql = "insert into list (username, listName) values (?, ?)";
////        groceryListRepository.update(sql, groceryList.getUsername(), groceryList.getListName());
//            groceryListRepository.save(groceryList);
//    }

    public List<GroceryList> getAllGroceryListsByUsername(String username){
        return groceryListRepository.getAllByUsername(username);
    }
}
