package com.icbt.restaurant.MenuTypeAssign;

import com.icbt.restaurant.MenuType.MenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuTypeAssignRepo extends JpaRepository<MenuTypeAssign, Integer> {

}
