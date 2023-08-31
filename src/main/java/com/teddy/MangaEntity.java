package com.teddy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

import java.util.Objects;

@MongoEntity(collection="mangas" )
public class MangaEntity {
    public ObjectId id;

    @JsonProperty
    public String title;

    @JsonProperty
    public String author;

    @JsonProperty
    public String genre;

    public MangaEntity(ObjectId id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public MangaEntity(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public MangaEntity() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MangaEntity that = (MangaEntity) o;
        return Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, genre);
    }
}
