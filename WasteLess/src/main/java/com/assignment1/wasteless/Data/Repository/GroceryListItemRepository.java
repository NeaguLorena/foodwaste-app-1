package com.assignment1.wasteless.Data.Repository;

import com.assignment1.wasteless.Presentation.Model.GroceryList;
import com.assignment1.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroceryListItemRepository extends JpaRepository<GroceryListItem, Integer> {

    List<GroceryListItem> findAllByListId(int listId);
    GroceryListItem findItemByItemId(int itemId);

}
