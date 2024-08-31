package com.icbt.restaurant.BranchTables;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BranchTables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    int tablesCount;

    @Column(unique = true)
    private Integer branchId;
}
