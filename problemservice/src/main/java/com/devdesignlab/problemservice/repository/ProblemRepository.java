package com.devdesignlab.problemservice.repository;

import com.devdesignlab.problemservice.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProblemRepository extends JpaRepository<Problem, UUID> {
}
