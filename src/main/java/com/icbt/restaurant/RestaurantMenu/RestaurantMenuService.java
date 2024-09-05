package com.icbt.restaurant.RestaurantMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantMenuService {

    @Autowired
    private RestaurantMenuRepo restaurantMenuRepo;

    public ResponseEntity<?> GetAll(int page, int pageSize, int order) {
        return ResponseEntity.ok(restaurantMenuRepo.findAll(PageRequest.of(page, pageSize, Sort.by(order == 0 ? Sort.Direction.DESC : Sort.Direction.ASC, "id"))));
    }

    public ResponseEntity<?> Add(RestaurantMenu restaurantMenu) {
//        restaurantMenu.setMenuTypes(null);
//        Check menu exist or not
        if(restaurantMenu.getId()==null){
            restaurantMenu.setId(0);
        }
        Optional<RestaurantMenu> restaurantMenuOptional = restaurantMenuRepo.findById(restaurantMenu.getId());
        if (restaurantMenuOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This menu item already exist !");
        } else {
            return ResponseEntity.ok(restaurantMenuRepo.save(restaurantMenu));
        }
    }

    public ResponseEntity<?> Update(RestaurantMenu restaurantMenu) {
//        restaurantMenu.setMenuTypes(null);
        if(restaurantMenu.getId()==null){
            restaurantMenu.setId(0);
        }
//        Check menu exist or not
        Optional<RestaurantMenu> restaurantMenuOptional = restaurantMenuRepo.findById(restaurantMenu.getId());
        if (restaurantMenuOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This menu item not found !");
        } else {
            return ResponseEntity.ok(restaurantMenuRepo.save(restaurantMenu));
        }
    }

    public ResponseEntity<?> Search(String search, int page, int page_size, int order) {
        return ResponseEntity.ok(restaurantMenuRepo.findByTypeNameContainsOrMenuTypeAssignList_MenuType_TypeContains(search,search,PageRequest.of(page,page_size,Sort.by(order==0?Sort.Direction.DESC: Sort.Direction.ASC,"id"))));
    }
}
