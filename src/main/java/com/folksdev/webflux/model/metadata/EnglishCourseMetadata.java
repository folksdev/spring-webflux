package com.folksdev.webflux.model.metadata;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class EnglishCourseMetadata extends CourseMetadata{

    private String level;
    private List<String> books;
}
