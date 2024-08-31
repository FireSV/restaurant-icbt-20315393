package com.icbt.restaurant.RestaurantMenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantMenuRepo extends JpaRepository<RestaurantMenu, Integer> {
}
