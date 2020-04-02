package com.assignment1.wasteless.Presentation.Controller;

import com.assignment1.wasteless.Data.Repository.GroceryListRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class GroceryListController {

    @Autowired
    private GroceryListRepository groceryListRepository;

    @PostMapping("/groceryLists-user")
    public String createGroceryList(@Valid GroceryList groceryList) {
        groceryListRepository.save(groceryList);
        return "redirect:/groceryLists-user";
    }

    @GetMapping("/groceryLists-user")
    public String getAllGroceryLists(Principal principal, Model model) {
//        GroceryList groceryList = new GroceryList();
//        groceryList.setUsername(principal.getName());
        model.addAttribute("groceryLists", groceryListRepository.getAllByUsername(principal.getName()));
        return "grocery_lists";
    }

}
