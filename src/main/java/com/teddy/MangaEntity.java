package com.teddy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

@MongoEntity(collection="mangas" )
public class MangaEntity {
    public ObjectId id;

    @JsonProperty
    public String title;

    @JsonProperty
    public String author;

    @JsonProperty
    public String genre;
}
