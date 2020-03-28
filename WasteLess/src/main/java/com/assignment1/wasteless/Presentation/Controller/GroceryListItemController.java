package com.assignment1.wasteless.Presentation.Controller;

import com.assignment1.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/groceryListItem")
public class GroceryListItemController {

    @Autowired
    private GroceryListItemRepository groceryListItemRepository;

    @GetMapping
    public List<GroceryListItem> getAllGroceryListItems() {
        return groceryListItemRepository.findAll();
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<GroceryListItem> getGroceryListItemById(@PathVariable(value = "itemId") int itemId) {

        GroceryListItem item = groceryListItemRepository.findById(itemId)
                .orElseThrow(() -> new NoSuchElementException("Item not availbele for itemId :" + itemId));

        return ResponseEntity.ok().body(item);
    }
}
