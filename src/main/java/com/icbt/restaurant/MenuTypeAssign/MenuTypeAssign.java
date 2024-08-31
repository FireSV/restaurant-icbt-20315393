package com.icbt.restaurant.MenuTypeAssign;

import com.icbt.restaurant.MenuType.MenuType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MenuTypeAssign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private Integer menuTypeHeader;

    @Column
    private Integer menuTypeId;

    @Column(columnDefinition = "TINYINT")
    private Boolean enable;

    //    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true )
//    private List<MenuType> menuTypeList;
    @ManyToOne
    @JoinColumn(name = "menuTypeId", insertable = false, updatable = false)
    private MenuType menuType;
}
