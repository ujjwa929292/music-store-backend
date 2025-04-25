package com.musicstrore.themusicstroreapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.musicstore.themusicstoreapp.models.FileCreateDTO;
import com.musicstore.themusicstoreapp.models.FileDTO;
import com.musicstrore.themusicstroreapp.accessors.ProductRepository;
import com.musicstrore.themusicstroreapp.accessors.models.Product;
import com.musicstrore.themusicstroreapp.constants.Constants;
import com.musicstrore.themusicstroreapp.service.FileService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.java.com.musicstore.themusicstoreapp.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final ModelMapper modelMapper;
    private final FileRepository fileRepository;
    private final ProductRepository productRepository;

    @Override
    public List<FileDTO> getAllTapes() {
        List<File> tapes = fileRepository.getAllTapes(Constants.FILE_TYPE_VIDEO);
        return tapes.stream()
                .map(file -> modelMapper.map(file, FileDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public File createFile(FileCreateDTO fileDTO) {
        Product product = productRepository.findById(fileDTO.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        File file = modelMapper.map(fileDTO, File.class);
        file.setId(null);
        File createdFile = fileRepository.save(file);
        List<UUID> files;
        if (product.getFileIds() != null) {
            files = product.getFileIds();
        } else {
            files = new ArrayList<>();
        }
        files.add(createdFile.getId());
        product.setFileIds(files);
        productRepository.save(product);
        return createdFile;
    }

}