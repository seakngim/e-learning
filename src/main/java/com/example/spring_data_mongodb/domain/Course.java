package com.example.spring_data_mongodb.domain;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collation = "courses")
@Setter
@Getter
@NoArgsConstructor
@Data
public class Course {

    @Id
    private String id;

    private String uuid;
    private String title;
    private String slug;
    private String description;
    private String thumbnail;
    private String contents;
    private BigDecimal price;
    private Integer discount;
    private String categoryName;
//    private List<Section> sections;

    private String code;
    private String instructorUsername;

    private Boolean isPaid;
    private Boolean isDrafted;
    private Boolean isDeleted;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
