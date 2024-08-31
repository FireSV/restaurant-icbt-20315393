package com.icbt.restaurant.MenuTypeAssign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MenuTypeAssignService {
    @Autowired
    MenuTypeAssignRepo menuTypeAssignRepo;

    public ResponseEntity<?> Add(MenuTypeAssign menuTypeAssign) {
        return ResponseEntity.ok(menuTypeAssignRepo.save(menuTypeAssign));
    }
}
