package com.devdesignlab.problemservice.service;

import com.devdesignlab.problemservice.dto.ProblemDto;
import com.devdesignlab.problemservice.entity.Problem;
import com.devdesignlab.problemservice.repository.ProblemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProblemService implements com.devdesignlab.problemservice.service.interfaces.ProblemService {

    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }


    @Override
    public List<ProblemDto> getAllProblems() {
//        return problemRepository.findAll();
        return problemRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ProblemDto getProblemById(UUID id) {
         Problem problem=problemRepository.findById(id).orElseThrow();
         return convertToDto(problem);
    }

    private ProblemDto convertToDto(Problem problem) {
        ProblemDto dto = new ProblemDto();
        BeanUtils.copyProperties(problem, dto);
        return dto;
    }
}
