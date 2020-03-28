package com.assignment1.wasteless.Bussiness.Service;

import com.assignment1.wasteless.Data.Repository.GroceryListRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryListService {

    GroceryListRepository groceryListRepository;

    public List<GroceryList> getAllGroceryListsByUsername(String username){
        return groceryListRepository.getAllByUsername(username);
    }
}
