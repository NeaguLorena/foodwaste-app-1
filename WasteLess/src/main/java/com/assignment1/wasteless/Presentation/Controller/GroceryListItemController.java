package com.assignment1.wasteless.Presentation.Controller;

import com.assignment1.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
import com.assignment1.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class GroceryListItemController {

    @Autowired
    private GroceryListItemRepository groceryListItemRepository;

    @PostMapping("/groceryLists-user/{listId}")
    public String createGroceryListItem(@PathVariable int listId, @Valid GroceryListItem groceryListItem){
        groceryListItem.setListId(listId);
//        groceryListItem.setConsumptionDate(groceryListItem.getPurchaseDate());
        groceryListItemRepository.save(groceryListItem);
        return "redirect:/groceryLists-user/{listId}";
    }

    @GetMapping("/groceryLists-user/{listId}")
    public String getAllGroceryListItemsByListId(@PathVariable int listId, Model model) {
        model.addAttribute("groceryListItems", groceryListItemRepository.findAllByListId(listId));
        model.addAttribute("listId", listId);
        model.addAttribute("addItem", new GroceryListItem());
        return "list_items";
    }

    @RequestMapping("/groceryItem-list/delete/{itemId}")
    public String deleteGroceryListItem(@PathVariable int itemId) {
        int listId = groceryListItemRepository.findListByItemId(itemId);
        groceryListItemRepository.deleteById(itemId);
        return "redirect:/groceryLists-user/" + listId;
    }
//    @GetMapping("/{itemId}")
//    public ResponseEntity<GroceryListItem> getGroceryListItemById(@PathVariable(value = "itemId") int itemId) {
//
//        GroceryListItem item = groceryListItemRepository.findById(itemId)
//                .orElseThrow(() -> new NoSuchElementException("Item not availbele for itemId :" + itemId));
//
//        return ResponseEntity.ok().body(item);
//    }
}
