package com.example.theworld;

public class Cell {
    private String title;
    private String subtitle;
    private String emoji;

    public Cell(String title, String subtitle, String emoji) {
        this.title = title;
        this.subtitle = subtitle;
        this.emoji = emoji;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getEmoji() {
        return emoji;
    }
}

