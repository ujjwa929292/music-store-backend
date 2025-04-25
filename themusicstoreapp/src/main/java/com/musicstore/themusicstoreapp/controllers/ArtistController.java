package com.musicstore.themusicstoreapp.controllers;

import com.musicstore.themusicstoreapp.service.AlbumService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.themusicstoreapp.constants.UrlConstants;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(UrlConstants.ARTIST_API_BASE_PATH)
@RequiredArgsConstructor
public class ArtistController {
    private final AlbumService albumService;
}
