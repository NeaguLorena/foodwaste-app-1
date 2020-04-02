package com.assignment1.wasteless.Presentation.Controller;

import com.assignment1.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
import com.assignment1.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
public class GroceryListItemController {

    @Autowired
    private GroceryListItemRepository groceryListItemRepository;

    @PostMapping("/groceryLists-user/{listId}")
    public String createGroceryListItem(@Valid GroceryListItem groceryListItem) {
        if (groceryListItem.getName() != null)
            groceryListItemRepository.save(groceryListItem);
        return "redirect:/groceryLists-user/{listId}";
    }

    @GetMapping("/groceryLists-user/{listId}")
    public String getAllGroceryListItemsByListId(@PathVariable int listId, Model model) {
        model.addAttribute("groceryListItems", groceryListItemRepository.findAllByListId(listId));
        model.addAttribute("listId", listId);
        return "list_items";
    }

    @RequestMapping("/groceryItem-list/delete/{listId}/{itemId}")
    public String deleteGroceryListItem(@PathVariable int itemId, @PathVariable int listId) {
        groceryListItemRepository.deleteById(itemId);
        return "redirect:/groceryLists-user/" + listId;
    }

    @RequestMapping("/groceryItem-list/consume/{listId}/{itemId}")
    public String consumeGroceryListItem(@PathVariable int itemId, @PathVariable int listId) {
        GroceryListItem oldGroceryListItem = groceryListItemRepository.findItemByItemId(itemId);
        oldGroceryListItem.setConsumptionDate(new Date());
        groceryListItemRepository.save(oldGroceryListItem);
        return "redirect:/groceryLists-user/" + listId;
    }

}
