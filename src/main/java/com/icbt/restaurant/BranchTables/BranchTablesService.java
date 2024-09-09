package com.icbt.restaurant.BranchTables;

import com.icbt.restaurant.Branch.Branch;
import com.icbt.restaurant.Branch.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchTablesService {
    @Autowired
    BranchTablesRepo branchTablesRepo;
    @Autowired
    private BranchRepo branchRepo;

    public ResponseEntity<?> Add(BranchTables branchTables) {
        Optional<BranchTables> branchTablesOptional = branchTablesRepo.findByBranchId(branchTables.getBranchId());
        Optional<Branch> branchOptional = branchRepo.findById(branchTables.getBranchId());
        if (branchOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid branch id !");
        }
        if (branchTablesOptional.isPresent()) {
            branchTables.setId(branchTablesOptional.get().getId());
        }
        return ResponseEntity.ok(branchTablesRepo.save(branchTables));
    }

    public ResponseEntity<?> Update(BranchTables branchTables) {
        Optional<BranchTables> branchTablesOptional = branchTablesRepo.findById(branchTables.getId());
        if (branchTablesOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Table id not found !");
        }
        return ResponseEntity.ok(branchTablesRepo.save(branchTables));
    }

    public ResponseEntity<?> Get(int page, int pageSize) {
        return ResponseEntity.ok(branchTablesRepo.findAll(PageRequest.of(page, pageSize)));
    }
}
