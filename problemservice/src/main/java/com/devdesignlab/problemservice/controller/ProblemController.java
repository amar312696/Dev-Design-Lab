package com.devdesignlab.problemservice.controller;

import com.devdesignlab.problemservice.dto.ProblemDto;
import com.devdesignlab.problemservice.service.interfaces.ProblemService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/problems")
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService){
        this.problemService=problemService;
    }
    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok().body("OK");
    }
    @GetMapping
    public List<ProblemDto> getAllProblems(){
        return problemService.getAllProblems();
    }
    @GetMapping("/{id}")
    public ProblemDto getProblem(@PathVariable UUID id){
        return problemService.getProblemById(id);
    }

    @GetMapping("/{id}/template")
    public ResponseEntity<Resource> getTemplateZip(@PathVariable UUID id) throws MalformedURLException{
        ProblemDto problemDto =problemService.getProblemById(id);
        Path path = Path.of("",id+".zip");
        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok().body(resource);
    }

}
