package ru.astecom.controllers;

import io.github.asewhy.conversions.support.annotations.ShiftController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import paa.coder.noodleCriteriaBuilder.interfaces.NoodleFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.NoodleRestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.models.Song;
import ru.astecom.service.SongService;

import javax.validation.Valid;

@ShiftController
@RequestMapping("/api/songs")
public class SongController {
    @Autowired
    protected SongService songService;

    @GetMapping("/{songId}")
    public Song restFindById(@PathVariable("songId") @Valid Long songId) {
        return songService.restFindById(songId);
    }

    @PostMapping
    public RestPage<Song> listSongs(@NoodleFilter @Valid NoodleRestFilter filter) {
        return songService.restList(filter);
    }
}
