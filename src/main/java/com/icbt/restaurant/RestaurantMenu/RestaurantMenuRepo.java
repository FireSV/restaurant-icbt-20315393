package com.icbt.restaurant.RestaurantMenu;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantMenuRepo extends JpaRepository<RestaurantMenu, Integer> {
//    @Query("""
//            select r from RestaurantMenu r left join r.menuTypeAssignList menuTypeAssignList
//            where r.typeName like concat('%', ?1, '%') or menuTypeAssignList.menuType.type like concat('%', ?2, '%')""")
//
    @Query("""
            select r from RestaurantMenu r left join r.menuTypeAssignList menuTypeAssignList
            where r.typeName like concat('%', ?1, '%') or menuTypeAssignList.menuType.type like concat('%', ?2, '%')""")
    Page<RestaurantMenu> findByTypeNameContainsOrMenuTypeAssignList_MenuType_TypeContains(String typeName, String type, Pageable pageable);


//    @Query(value = "SELECT * FROM restaurant.restaurant_menu m left join menu_type_assign ma on m.id=ma.menu_type_header left join menu_type mt on ma.menu_type_id=mt.id where m.type_name=?1 or mt.type=?2",nativeQuery = true)
//    Page<RestaurantMenu> findByTypeNameContainsOrMenuTypeAssignList_MenuType_TypeContains(String typeName, String type, Pageable pageable);
}
