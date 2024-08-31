package com.icbt.restaurant.RestaurantMenu;

import com.icbt.restaurant.MenuType.MenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/restaurant-menu")
public class RestaurantMenuController {
    @Autowired
    RestaurantMenuService restaurantMenuService;

    @GetMapping(path = "/{page}/{page_size}/{order}")
    ResponseEntity<?> GetAll(@PathVariable int page, @PathVariable int page_size, @PathVariable int order) {
        return restaurantMenuService.GetAll(page, page_size, order);
    }

    @PostMapping(path = "")
    ResponseEntity<?> Add(@RequestBody RestaurantMenu restaurantMenu) {
        return restaurantMenuService.Add(restaurantMenu);
    }

    @PutMapping(path = "")
    ResponseEntity<?> Update(@RequestBody RestaurantMenu restaurantMenu) {
        return restaurantMenuService.Update(restaurantMenu);
    }

}
