package com.musicstore.themusicstoreapp.service.impl;

import org.springframework.stereotype.Service;
import com.musicstore.themusicstoreapp.service.TrackService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;
    private final ModelMapper modelMapper;

    // ...existing implementation methods from TrackService...
}
