package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
