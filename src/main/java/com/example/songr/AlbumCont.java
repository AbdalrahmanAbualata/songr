package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumCont {
    @GetMapping("/albums")
    public String getThreeAlbums(Model model){
        Album album1 = new Album("erry-Jacks-Seasons-In-The-Sun", "abd ata",6,1440,"https://static.stereogum.com/uploads/2019/05/Terry-Jacks-Seasons-In-The-Sun-1557350323-520x520.jpg");
        Album album2 = new Album("pain", "Ryan Jones",8,1870,"https://d1csarkz8obe9u.cloudfront.net/posterpreviews/artistic-album-cover-design-template-d12ef0296af80b58363dc0deef077ecc_screen.jpg?ts=1561488440");
        Album album3 = new Album("Jalebi Baby", "Jalebi Baby",5,1200,"https://i.ytimg.com/vi/MMmrC83Bva0/maxresdefault.jpg");
        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        model.addAttribute("albums",albums);

        return "albums";
    }
}
