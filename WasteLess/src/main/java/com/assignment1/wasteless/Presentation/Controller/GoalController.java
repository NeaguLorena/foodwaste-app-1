package com.assignment1.wasteless.Presentation.Controller;

import com.assignment1.wasteless.Data.Repository.GoalRepository;
import com.assignment1.wasteless.Presentation.Model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class GoalController {

    @Autowired
    GoalRepository goalRepository;

    @PostMapping("/set-goal")
    public String createGoal(Goal goal, Principal principal) {
        goal.setUsername(principal.getName());
        goal.setDay(new Date());
        goalRepository.save(goal);
        return "redirect:/groceryLists-user";
    }

//    @GetMapping("/set-goal")
//    public String getGoal(Principal principal, Model model) {
//        List<Goal> goals = goalRepository.getAllByUsername(principal.getName());
//        model.addAttribute("goals", goals);
//        return "grocery_lists";
//
//    }
}
