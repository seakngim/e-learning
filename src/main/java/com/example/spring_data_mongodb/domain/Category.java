package com.example.spring_data_mongodb.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "categories")
@Setter
@Getter
@NoArgsConstructor
@Data
public class Category {

    @Id
    private String id;
    private String uuid;
    private String name;
    private String icon;
    private Boolean isDeleted;
    private String description;

}
