package com.folksdev.webflux.dto;

import com.folksdev.webflux.model.metadata.CourseMetadata;

public record CourseDto(String name, String description, Integer duration, String teacher, CourseMetadata courseMetadata) {
}
