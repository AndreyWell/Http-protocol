package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cats {
    private String id;
    private String text;
    private String type;
    private String user;
    private Integer upVotes;

    public Cats(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") Integer upVotes
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upVotes = upVotes;
    }

    public Integer getUpVotes() {
        return upVotes;
    }

    @Override
    public String toString() {
        return "Cats{" +
                "\n id='" + id + '\'' +
                "\n text='" + text + '\'' +
                "\n type='" + type + '\'' +
                "\n user='" + user + '\'' +
                "\n upVotes=" + upVotes +
                '}';
    }
}
