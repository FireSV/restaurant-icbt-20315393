package com.icbt.restaurant.MenuTypeAssign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/menu-type-assign")
public class MenuTypeAssignController {
    @Autowired
    MenuTypeAssignService menuTypeAssignService;

    @PostMapping(path = "")
    ResponseEntity<?> Add(@RequestBody MenuTypeAssign menuTypeAssign) {
        return menuTypeAssignService.Add(menuTypeAssign);
    }
}
