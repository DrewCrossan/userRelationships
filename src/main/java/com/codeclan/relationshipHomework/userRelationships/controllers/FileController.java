package com.codeclan.relationshipHomework.userRelationships.controllers;

import com.codeclan.relationshipHomework.userRelationships.models.File;
import com.codeclan.relationshipHomework.userRelationships.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping(value="/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/files")
    public ResponseEntity<File> postRaid(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}
