package com.icbt.restaurant.MenuType;

import com.icbt.restaurant.RestaurantMenu.RestaurantMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/menu-type")
public class MenuTypeController {
    @Autowired
    MenuTypeService menuTypeService;

    @GetMapping(path = "/{page}/{page_size}/{order}")
    ResponseEntity<?> GetAll(@PathVariable int page, @PathVariable int page_size, @PathVariable int order) {
        return menuTypeService.GetAll(page, page_size, order);
    }

    @PostMapping(path = "")
    ResponseEntity<?> Add(@RequestBody MenuType menuType) {
        return menuTypeService.Add(menuType);
    }

    @PutMapping(path = "")
    ResponseEntity<?> Update(@RequestBody MenuType menuType) {
        return menuTypeService.Update(menuType);
    }

}
