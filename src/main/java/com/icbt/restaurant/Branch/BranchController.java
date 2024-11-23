package com.icbt.restaurant.Branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @PostMapping(path = "")
    ResponseEntity<?>Add(@RequestBody Branch branch){
        return branchService.Add(branch);
    }

    @PutMapping(path = "")
    ResponseEntity<?> Update(@RequestBody Branch branch) {
        return branchService.Update(branch);
    }

    @PostMapping(path = "status-change")
    ResponseEntity<?> StatusChange(@RequestParam int branch_id, boolean status) {
        return branchService.StatusChange(branch_id,status);
    }
    @GetMapping(path = "/{page}/{page_size}")
    ResponseEntity<?> GetAll(@PathVariable int page,@PathVariable int page_size){
        return branchService.GetAll(page,page_size);
    }

    @PostMapping(path = "Fireeeee")
    ResponseEntity<?>Gettt(@RequestBody Branch branch){
        return ResponseEntity.ok("Fireee");
    }
}
