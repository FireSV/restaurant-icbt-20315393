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

    @GetMapping(path = "/{page}/{page_size}")
    ResponseEntity<?> Get(@PathVariable int page,@PathVariable int page_size) {
        return branchTablesService.Get(page,page_size);
    }

    @PutMapping(path = "")
    ResponseEntity<?> Update(@RequestBody BranchTables branchTables) {
        return branchTablesService.Update(branchTables);
    }
}
