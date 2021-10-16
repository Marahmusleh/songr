package com.application.songr.repository;

import com.application.songr.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song,Integer> {

    }

