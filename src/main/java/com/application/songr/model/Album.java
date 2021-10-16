package com.application.songr.model;

import javax.persistence.*;
import java.util.List;
@Entity  //no @Table annotation exists, it is assumed that this entity is mapped to a table named Album
//every class such a table and every class need a repository interface to implement the methods of crud
//Spring Data JPA aims to significantly improve the implementation of data access layers by reducing the effort
// to the amount that’s actually needed.
public class Album {
    private String title;
    private int songCount;
    private int length;
    private String imageUrl;
    private String artist;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    public Album(String title,  String artist ,int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    } //constructor is the one you use to create instances of Album to be saved to the database.
    public Album(String title, String artist, int songCount, String imageUrl, int length, List songs) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.imageUrl = imageUrl;
        this.length = length;
        this.songs = songs;
    }

    public Album() {
//The default constructor exists only for the sake of JPA.
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", songCount=" + songCount +
                ", length=" + length +
                ", imageUrl='" + imageUrl + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}