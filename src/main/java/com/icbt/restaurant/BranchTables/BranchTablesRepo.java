package com.icbt.restaurant.BranchTables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchTablesRepo extends JpaRepository<BranchTables,Integer> {

    @Query("select b from BranchTables b where b.branchId = ?1")
    Optional<BranchTables> findByBranchId(Integer branchId);
}
