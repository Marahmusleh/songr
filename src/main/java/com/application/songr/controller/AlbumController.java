package com.application.songr.controller;

import com.application.songr.model.Album;
import com.application.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
@Controller
public class AlbumController {
  @Autowired
     AlbumRepository repo;


//    @GetMapping("/albums")
//    public String getAlbums(Model model){
//        Album al1 = new Album("The Most Recommended","Adham Nabulsi",20,60,"https://i.ytimg.com/vi/RIuhSeGefxk/maxresdefault.jpg");
//        Album al2 = new Album("ya fatene","Mohammed Hamaki",13,60,"https://aawsat.com/sites/default/files/styles/article_img_top/public/2021/08/05/1628167094554394300.jpg?itok=WYuYEO-U");
//        Album al3 = new Album("The Magic Of Fairuz","Fairuz",10,70,"https://i.ytimg.com/vi/iV1FYH4_wIM/maxresdefault.jpg");
//        List<Album> albums = new ArrayList<>();
//        albums.add(al1);
//        albums.add(al2);
//        albums.add(al3);
//        model.addAttribute("Albums",albums);
//        return "albums";
//    }

    @GetMapping ("/albums")
    public String getAlbum(Model model){
        List<Album> albums = repo.findAll();
        model.addAttribute("Albums",albums);
        return "albums";
    }

    @PostMapping("/albums")
    public RedirectView createAlbum(@ModelAttribute Album album) {
        Album newALbum = new Album();
        repo.save(newALbum);
        return new RedirectView("albums");
    }


}
