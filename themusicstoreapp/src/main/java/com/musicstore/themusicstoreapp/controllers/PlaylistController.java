package com.musicstore.themusicstoreapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.themusicstoreapp.constants.UrlConstants;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(UrlConstants.PLAYLIST_API_BASE_PATH)
@RequiredArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;
}
