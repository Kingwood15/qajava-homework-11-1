package ru.netology.manager.MovieManager;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MovieManager {

    private Movie[] movies = new Movie[0];
    private int numberLastMovies;

    public MovieManager() {

        this.numberLastMovies = 10;
    }

    public MovieManager(int numberLastMovies) {

        this.numberLastMovies = numberLastMovies;

    }

    public void add(Movie newMovie) {

        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        // в цикле копируется массив
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        // добавление нового элемента
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newMovie;

        movies = tmp;
    }

    public Movie[] findAll() {

        return movies;
    }

    public Movie[] findLast() {

        if (numberLastMovies < movies.length) {

            Movie[] result = new Movie[numberLastMovies];

            //заполняем массив в обратном порядке
            for (int i = 0; i < numberLastMovies; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }

            return result;

        } else {

            Movie[] result = new Movie[movies.length];

            //заполняем массив в обратном порядке
            for (int i = 0; i < movies.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }

            return result;
        }
    }
}
