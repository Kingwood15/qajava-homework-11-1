package ru.netology.manager.MovieManager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    private int id;
    private String imageUrl;
    private String name;
    private String genre;
}
