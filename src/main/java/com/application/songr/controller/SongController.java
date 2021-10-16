package com.application.songr.controller;

import com.application.songr.model.Album;
import com.application.songr.model.Song;
import com.application.songr.repository.AlbumRepository;
import com.application.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/song")
    public String showAllSongs(Model model){
        model.addAttribute("song",songRepository.findAll());
        return "songs";
    }

    @GetMapping("/showalbum")
    public String findAlbumbyArtist(@RequestParam String artist, Model model){
        Album album = albumRepository.findAlbumByArtist(artist);
        model.addAttribute("album",album);

        return "album";
    }


    @GetMapping("/addSong/{artist}")
    public String addSongtoAlbum(@PathVariable String artist, Model model) {
        Album album =  albumRepository.findAlbumByArtist(artist);
        model.addAttribute("album", album);
        return "addsong";
    }

    @PostMapping("/getSongToAlbum")
    @ResponseBody
    public RedirectView getSongToAlbum(@ModelAttribute Song MySong, @RequestParam String artist, Model model){
        Album album= albumRepository.findAlbumByArtist(artist);
        MySong.setAlbum(album);
        model.addAttribute("MySong", MySong);
        songRepository.save(MySong);
        String url = "/showalbum?artist=" + artist;
        return new RedirectView(url);
    }
}
