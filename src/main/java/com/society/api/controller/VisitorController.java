package com.society.api.controller;

import com.society.api.exception.ResourceNotFoundException;
import com.society.api.model.Visitor;
import com.society.api.repository.VisitorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by vijay pawar
 */
@RestController
@RequestMapping("/api")
public class VisitorController {

    @Autowired
    VisitorRepository visitorRepository;

    @GetMapping("/visitors")
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @PostMapping("/visitors")
    public Visitor createVisitor(@Valid @RequestBody Visitor note) {
        return visitorRepository.save(note);
    }

    @GetMapping("/visitors/{id}")
    public Visitor getVisitorById(@PathVariable(value = "id") Long noteId) {
        return visitorRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor", "id", noteId));
    }

    @PutMapping("/visitors/{id}")
    public Visitor updateVisitor(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody Visitor visitorDetails) {

        Visitor visitor = visitorRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor", "id", noteId));

        visitor.setFname(visitorDetails.getFname());
        visitor.setLname(visitorDetails.getLname());
        visitor.setMobile(visitorDetails.getMobile());

        Visitor updatedVisitor = visitorRepository.save(visitor);
        return updatedVisitor;
    }

    @DeleteMapping("/visitors/{id}")
    public ResponseEntity<?> deleteVisitor(@PathVariable(value = "id") Long noteId) {
        Visitor note = visitorRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        visitorRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}
