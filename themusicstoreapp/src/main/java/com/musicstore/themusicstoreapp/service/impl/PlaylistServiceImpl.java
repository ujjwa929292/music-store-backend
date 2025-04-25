package com.musicstore.themusicstoreapp.service.impl;

import org.springframework.stereotype.Service;

import com.musicstore.themusicstoreapp.service.PlaylistService;

import lombok.RequiredArgsConstructor;
import main.java.com.musicstore.themusicstoreapp.accessors.repositories.PlaylistTrackRepository;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final PlaylistTrackRepository playlistTrackRepository;
    private final ModelMapper modelMapper;
    
    // ...existing implementation methods...
}
