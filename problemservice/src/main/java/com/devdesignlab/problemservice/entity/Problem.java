package com.devdesignlab.problemservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Problem {
    @Id
    private UUID id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String difficulty;

    @ElementCollection
    private List<String> tags;

    private String templateZipUrl;
    private String createdBy;
    private LocalDateTime createdAt;
}
