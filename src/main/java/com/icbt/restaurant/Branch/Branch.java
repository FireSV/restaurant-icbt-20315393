package com.icbt.restaurant.Branch;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String branchName;

    @Column
    private String address;

    @Column(columnDefinition = "TINYINT")
    private Boolean enable;
}
