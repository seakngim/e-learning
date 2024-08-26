package com.example.spring_data_mongodb.feature.category;


import com.example.spring_data_mongodb.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {
}
