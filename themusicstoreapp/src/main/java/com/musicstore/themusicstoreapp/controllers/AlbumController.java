package com.musicstore.themusicstoreapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.themusicstoreapp.constants.UrlConstants;
import com.musicstore.themusicstoreapp.service.AlbumService;
import com.musicstore.themusicstoreapp.accessors.models.Album;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping(UrlConstants.ALBUM_API_BASE_PATH)
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }
}
