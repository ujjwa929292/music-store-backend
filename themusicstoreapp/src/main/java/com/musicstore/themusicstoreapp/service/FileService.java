package com.musicstore.themusicstoreapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.musicstore.themusicstoreapp.accessors.models.File;
import com.musicstore.themusicstoreapp.accessors.repositories.FileRepository;
import com.musicstore.themusicstoreapp.models.FileCreateDTO;
import com.musicstore.themusicstoreapp.models.FileDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    public List<FileDTO> getAllTapes() {
        return fileRepository.findAll().stream()
            .map(file -> modelMapper.map(file, FileDTO.class))
            .toList();
    }

    public File createFile(FileCreateDTO fileDTO) {
        File file = modelMapper.map(fileDTO, File.class);
        return fileRepository.save(file);
    }
}