package com.devdesignlab.problemservice.service.interfaces;


import com.devdesignlab.problemservice.dto.ProblemDto;

import java.util.List;
import java.util.UUID;

public interface ProblemService {

    List<ProblemDto> getAllProblems();
    ProblemDto getProblemById(UUID id);
}
