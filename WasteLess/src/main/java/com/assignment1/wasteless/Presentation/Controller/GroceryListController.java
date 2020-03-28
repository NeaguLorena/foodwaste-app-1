package com.assignment1.wasteless.Presentation.Controller;

import com.assignment1.wasteless.Bussiness.Service.GroceryListService;
import com.assignment1.wasteless.Data.Repository.GroceryListRepository;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
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
//@RequestMapping("/groceryList")
public class GroceryListController {

    @Autowired
    private GroceryListRepository groceryListRepository;
    private GroceryListService groceryListService;
    //private UserService userService;

//    @GetMapping
//    public List<GroceryList> getAllGroceryLists() {
//        return groceryListRepository.findAll();
//    }

//    @PostMapping("/createList")
    @PostMapping("/groceryLists-user")
    public String createGroceryList(@Valid GroceryList groceryList){
        groceryListRepository.save(groceryList);
        return "redirect:/groceryLists-user";
    }

    @GetMapping("/groceryLists-user")
    public String getAllGroceryLists(Principal principal, Model model) {
        GroceryList groceryList = new GroceryList();
        groceryList.setUsername(principal.getName());
        model.addAttribute("addList", groceryList);
        model.addAttribute("groceryLists", groceryListRepository.getAllByUsername(principal.getName()));
        return "grocery_lists";
    }

//    @RequestMapping("/groceryLists-user/delete/{listId}")
//    public String deleteGroceryList(@PathVariable("listId") Integer listId) {
//        groceryListRepository.deleteGroceryList(listId);
//        return "redirect:/groceryLists-user";
//    }

//    @GetMapping("/{listId}")
//    public ResponseEntity<GroceryList> getGroceryListById(@PathVariable(value = "listId") int listId) {
//
//        GroceryList list = groceryListRepository.findById(listId)
//                .orElseThrow(() -> new NoSuchElementException("List not availbele for listId :" + listId));
//
//        return ResponseEntity.ok().body(list);
//    }

}
