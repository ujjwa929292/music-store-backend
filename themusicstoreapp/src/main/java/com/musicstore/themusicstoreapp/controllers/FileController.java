package com.musicstore.themusicstoreapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.musicstore.themusicstoreapp.accessors.models.File;
import com.musicstore.themusicstoreapp.constants.UrlConstants;
import com.musicstore.themusicstoreapp.models.FileCreateDTO;
import com.musicstore.themusicstoreapp.models.FileDTO;
import com.musicstore.themusicstoreapp.service.FileService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping(UrlConstants.FILE_API_BASE_PATH)
@Tag(name = "File", description = "Operations related to files")
@CrossOrigin(maxAge = 3600)
@Validated
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    // Get all Videos
    @GetMapping("/tapes")
    public ResponseEntity<List<FileDTO>> getAllTapes() {
        List<FileDTO> tapes = fileService.getAllTapes();
        return ResponseEntity.ok(tapes);
    }

    // Get all Videos
    @PostMapping
    public ResponseEntity<File> createFile(@RequestBody FileCreateDTO fileDTO) {
        File createdFile = fileService.createFile(fileDTO);

        return new ResponseEntity<>(createdFile, HttpStatus.CREATED);
    }

}
