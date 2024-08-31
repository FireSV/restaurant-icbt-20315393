package com.icbt.restaurant.RestaurantMenu;

import com.icbt.restaurant.MenuType.MenuType;
import com.icbt.restaurant.MenuTypeAssign.MenuTypeAssign;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class RestaurantMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String typeName;// break first etc ...


    @OneToMany(mappedBy = "menuTypeHeader", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuTypeAssign> menuTypeAssignList;

//    @OneToMany
//    @JoinColumn(referencedColumnName = "menuId")
//    private List<MenuType> menuTypeDetails;

//@OneToMany(mappedBy = "menuId", cascade = CascadeType.ALL, orphanRemoval = true)
//private List<MenuType> menuTypes;
}
