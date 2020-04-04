package com.assignment1.wasteless.Presentation.Controller;

import ch.qos.logback.core.joran.conditional.ElseAction;
import com.assignment1.wasteless.Bussiness.Service.NotificationService;
import com.assignment1.wasteless.Bussiness.Service.ReminderService;
import com.assignment1.wasteless.Data.Repository.GoalRepository;
import com.assignment1.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment1.wasteless.Data.Repository.GroceryListRepository;
import com.assignment1.wasteless.Presentation.Model.Goal;
import com.assignment1.wasteless.Presentation.Model.GroceryList;
import com.assignment1.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class GroceryListController {

    @Autowired
    private GroceryListRepository groceryListRepository;
    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private ReminderService reminderService;
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/groceryLists-user")
    public String createGroceryList(@Valid GroceryList groceryList, Principal principal) {
        groceryList.setUsername(principal.getName());
        groceryListRepository.save(groceryList);
        return "redirect:/groceryLists-user";
    }

    @GetMapping("/groceryLists-user")
    public String getAllGroceryLists(Principal principal, Model model) {
        List<Goal> goals = goalRepository.getAllByUsername(principal.getName());
        List<GroceryListItem> itemsToExpire = notificationService.getItemsAboutToExpire(principal.getName());
        Goal g = goals.get(goals.size() - 1);
        String message, expirationMessage;
        if (g != null)
            message = reminderService.getReminder(principal.getName(), g);
        else message = "No goal set yet!";
        if (itemsToExpire.size() > 0) {
            expirationMessage = "Some items are about to expire tomorrow!";
        } else expirationMessage = "";

        model.addAttribute("itemsToExpire", itemsToExpire);
        model.addAttribute("expirationMessage", expirationMessage);
        model.addAttribute("message", message);
        model.addAttribute("goals", goals);
        model.addAttribute("groceryLists", groceryListRepository.getAllByUsername(principal.getName()));
        return "grocery_lists";
    }

}
