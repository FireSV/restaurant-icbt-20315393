package com.icbt.restaurant.MenuType;

import com.icbt.restaurant.RestaurantMenu.RestaurantMenu;
import com.icbt.restaurant.RestaurantMenu.RestaurantMenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuTypeService {
    @Autowired
    private MenuTypeRepo menuTypeRepo;

    public ResponseEntity<?> GetAll(int page, int pageSize, int order) {
        return ResponseEntity.ok(menuTypeRepo.findAll(PageRequest.of(page, pageSize, Sort.by(order == 0 ? Sort.Direction.DESC : Sort.Direction.ASC, "id"))));
    }

    public ResponseEntity<?> Add(MenuType restaurantMenu) {
//        Check menu exist or not
        if(restaurantMenu.getId()==null){
            restaurantMenu.setId(0);
        }
        Optional<MenuType> restaurantMenuOptional = menuTypeRepo.findById(restaurantMenu.getId());
        if (restaurantMenuOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This menu item already exist !");
        } else {
            return ResponseEntity.ok(menuTypeRepo.save(restaurantMenu));
        }
    }

    public ResponseEntity<?> Update(MenuType menuType) {
        if(menuType.getId()==null){
            menuType.setId(0);
        }
//        Check menu exist or not
        Optional<MenuType> restaurantMenuOptional = menuTypeRepo.findById(menuType.getId());
        if (restaurantMenuOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This menu item not found !");
        } else {
            return ResponseEntity.ok(menuTypeRepo.save(menuType));
        }
    }
}
