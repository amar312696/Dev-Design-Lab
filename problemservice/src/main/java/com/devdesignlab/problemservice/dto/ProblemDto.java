package com.devdesignlab.problemservice.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ProblemDto {

    private UUID id;
    private String title;
    private String description;
    private String difficulty;
    private List<String> tags;
    private String templateZipUrl;
    private String createdBy;
    private LocalDateTime createdAt;
}
