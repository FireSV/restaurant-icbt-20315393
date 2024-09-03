package com.icbt.restaurant.MenuType;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MenuType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String type; // Buffet or Ala carte

//    @Column
//    private Integer menuId; // Buffet or Ala carte


}
