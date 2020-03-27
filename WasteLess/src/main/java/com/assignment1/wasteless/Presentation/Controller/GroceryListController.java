package com.assignment1.wasteless.Presentation.Controller;

import com.assignment1.wasteless.Data.Repository.GroceryListRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/groceryList")
public class GroceryListController {

    @Autowired
    private GroceryListRepository GroceryListRepository;

    @GetMapping
    public List<GroceryList> getAllGroceryLists() {
        return GroceryListRepository.findAll();
    }

    @GetMapping("/{listId}")
    public ResponseEntity<GroceryList> getGroceryListById(@PathVariable(value = "listId") Long listId) {

        GroceryList list = GroceryListRepository.findById(listId)
                .orElseThrow(() -> new NoSuchElementException("List not availbele for listId :" + listId));

        return ResponseEntity.ok().body(list);
    }

}
