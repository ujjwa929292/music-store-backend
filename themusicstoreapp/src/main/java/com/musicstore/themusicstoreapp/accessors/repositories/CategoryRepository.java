package com.musicstore.themusicstoreapp.accessors.repositories;

import com.musicstore.themusicstoreapp.accessors.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
