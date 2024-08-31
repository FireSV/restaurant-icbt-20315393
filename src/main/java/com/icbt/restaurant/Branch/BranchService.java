package com.icbt.restaurant.Branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    BranchRepo branchRepo;

    public ResponseEntity<?> Add(Branch branch) {
        branch.setId(null);
        return ResponseEntity.ok(branchRepo.save(branch));

    }

    public ResponseEntity<?> Update(Branch branch) {
        Optional<Branch> branchOptional = branchRepo.findById(branch.getId());
        if (branchOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This branch already exist !");
        }
        return ResponseEntity.ok(branchRepo.save(branch));
    }

    public ResponseEntity<?> StatusChange(int branchId, boolean status) {
        Optional<Branch> branchOptional = branchRepo.findById(branchId);
        if (branchOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Branch id");
        }
        branchOptional.get().setEnable(status);
        return ResponseEntity.ok(branchRepo.save(branchOptional.get()));
    }
}
