package com.musicstore.themusicstoreapp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.musicstore.themusicstoreapp.service.AlbumService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;

    // ...existing implementation methods from AlbumService...
}
