package com.example.songr.controller;


import com.example.songr.Models.Album;
import com.example.songr.Models.Song;
import com.example.songr.Repositories.AlbumRepository;
import com.example.songr.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongCont {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/addSong")
    public String viewAddSongForm(){
        return "addSong";
    }
    @GetMapping ("/addSong/{id}")
    public String redAddSongForm(Model model ,@PathVariable long id){
        Album album = albumRepository.findById(id).get();
        model.addAttribute("album", album);
        return "addSong";
    }


    @PostMapping("/addSongFinal/{id}")
    public Object addSongToDB(Model model , @PathVariable long id,
                              @RequestParam(value="title")String title,
                              @RequestParam(value="length")int length)
    {
        if(length <= 0)
            return new RedirectView("error/length and track can't be negative number or zero");
        try{
            Album album = albumRepository.findById(id).get();//try
            album.setLength(album.getLength()+ length);
            album.setSongCount(album.getSongCount()+1);
            int trackNumber = album.getSongCount();
            albumRepository.save(album);
            Song song = new Song(title, length,trackNumber,album);
            songRepository.save(song);
            model.addAttribute("songs", album.getSongs());
            return "songs";
        }
        catch(Exception e){
            return new RedirectView("error/album ID is not defined..");
        }
    }

    @GetMapping ("/songsForOneAlbum/{id}")
    public String showAllSongsForAlbum(Model model ,@PathVariable long id){
        Album album = albumRepository.findById(id).get();
        model.addAttribute("songs", album.getSongs());
        return "songs";
    }

    @GetMapping ("/songs")
    public String showAllSongs(Model model){
        List<Song> songs= (List<Song>) songRepository.findAll();
        model.addAttribute("songs",songs);

        return "songs";
    }
}
