package com.example.songr.controller;

import com.example.songr.Models.Album;
import com.example.songr.Repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumCont {

    @Autowired
    AlbumRepository albumRepository;
//    http://localhost:8080/albums
//    @GetMapping("/albums")
//    public String getThreeAlbums(Model model){
//        Album album1 = new Album("erry-Jacks-Seasons-In-The-Sun", "abd ata",6,1440,"https://static.stereogum.com/uploads/2019/05/Terry-Jacks-Seasons-In-The-Sun-1557350323-520x520.jpg");
//        Album album2 = new Album("pain", "Ryan Jones",8,1870,"https://d1csarkz8obe9u.cloudfront.net/posterpreviews/artistic-album-cover-design-template-d12ef0296af80b58363dc0deef077ecc_screen.jpg?ts=1561488440");
//        Album album3 = new Album("Jalebi Baby", "Jalebi Baby",5,1200,"https://i.ytimg.com/vi/MMmrC83Bva0/maxresdefault.jpg");
//        List<Album> albums = new ArrayList<>();
//        albums.add(album1);
//        albums.add(album2);
//        albums.add(album3);
//        model.addAttribute("albums",albums);
//
//        return "albums";
//    }

//    http://localhost:8080/testAddAlbums
    @GetMapping("/testAddAlbums")
    public RedirectView saveAlbums(Model model){
        Album album1 = new Album("erry-Jacks-Seasons-In-The-Sun", "abd ata",6,1440,"https://static.stereogum.com/uploads/2019/05/Terry-Jacks-Seasons-In-The-Sun-1557350323-520x520.jpg");
        albumRepository.save(album1);
        return new RedirectView("/albums");
    }

//    http://localhost:8080/albums
    @GetMapping("/albums")
    public String getThreeAlbums(Model model,Model model2){
        List<Album> albums = (List<Album>) albumRepository.findAll();
        model.addAttribute("albums",albums);
        return "albums";
    }
    @GetMapping("/addAlbum")
    public String viewAddAlbumForm(){
        return "addAlbum";
    }


    @PostMapping("/addAlbum")
    public RedirectView addAlbumToDB(Model model,
                                     @RequestParam(value="title") String title,
                                     @RequestParam(value="artist") String artist,
                                     @RequestParam(value="songCount") int songCount,
                                     @RequestParam(value="length") int length,
                                     @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }


//    http://localhost:8080/oneAlbums/{1}
    @GetMapping("/oneAlbums/{id}")
    public String getSpecificAlbums(Model m ,@PathVariable long id){
        try{
            Album album =  albumRepository.findById(id).get();
            List<Album> albums = new ArrayList<>();
            albums.add(album);
            m.addAttribute("albums",albums);
            return "albums";
        }
        catch (Exception e){
            String error = "Album ID is Not found..!";
            m.addAttribute("errorMessage",error);
            return "error";
        }
    }
}
