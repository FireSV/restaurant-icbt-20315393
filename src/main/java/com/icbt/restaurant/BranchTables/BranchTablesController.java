package com.icbt.restaurant.BranchTables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/branch-tables")
public class BranchTablesController {
    @Autowired
    BranchTablesService branchTablesService;

    @PostMapping(path = "")
    ResponseEntity<?> Add(@RequestBody BranchTables branchTables) {
        return branchTablesService.Add(branchTables);
    }

    @PutMapping(path = "")
    ResponseEntity<?> Update(@RequestBody BranchTables branchTables) {
        return branchTablesService.Update(branchTables);
    }
}
