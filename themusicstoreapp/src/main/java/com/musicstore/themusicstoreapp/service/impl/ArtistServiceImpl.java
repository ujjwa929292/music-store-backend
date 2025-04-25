package com.musicstore.themusicstoreapp.service.impl;

import org.springframework.stereotype.Service;
import com.musicstore.themusicstoreapp.service.ArtistService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private final ModelMapper modelMapper;
    
    // ...existing implementation methods...
}
