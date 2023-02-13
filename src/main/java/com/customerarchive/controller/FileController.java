package com.customerarchive.controller;

import com.customerarchive.model.Customer;
import com.customerarchive.model.File;
import com.customerarchive.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<File> saveFile(@RequestBody File file){
        return new ResponseEntity<File>(fileService.saveFile(file), HttpStatus.CREATED);
    }

    @GetMapping
    public List<File> getAllFiles(){
        return fileService.getAllFiles();
    }

    @PutMapping("{id}")
    public ResponseEntity<File> updateFile(@RequestBody File file ,@PathVariable("id") Long id){
        return new ResponseEntity<>(fileService.updateFile(file,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFile(@PathVariable("id") Long id){
        fileService.deleteFile(id);
        return new ResponseEntity<>("File deleted succesfully", HttpStatus.OK);
    }
}
