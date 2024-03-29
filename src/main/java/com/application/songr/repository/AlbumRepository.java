package com.application.songr.repository;

import com.application.songr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album,Long> {
    Album findAlbumByArtist(String artist);
}


// The type of entity and ID that it works with, Album and Long, are specified in the generic parameters
// By extending jpaRepository which extends CrudRepository, AlbumRepository inherits several methods for working with Album persistence,
// including methods for saving, deleting, and finding Customer entities.
