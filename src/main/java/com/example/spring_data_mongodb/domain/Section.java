package com.example.spring_data_mongodb.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Section {
    private String title;
    private Integer orderNo;
//    private List<Video> videos;
}
