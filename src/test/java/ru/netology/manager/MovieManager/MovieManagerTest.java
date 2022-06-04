package ru.netology.manager.MovieManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieManagerTest {

    @Mock
    private MoviesRepo repo = Mockito.mock(MoviesRepo.class);
    @InjectMocks
    private MovieManager manager = new MovieManager(repo);
    private Movie movie1 = new Movie(1, "urlMovie1", "Movie1", "genre1");
    private Movie movie2 = new Movie(2, "urlMovie2", "Movie2", "genre2");
    private Movie movie3 = new Movie(3, "urlMovie3", "Movie3", "genre3");

    @Test
    void shouldAddMoviesAndFindAll() {

        MovieManager manager = new MovieManager();
        int arraySize = 25;
        Movie[] expectedMovies = new Movie[arraySize];

        // заполнение списка фильмов
        for (int i = 0; i < arraySize; i++) {
            String number = Integer.toString(i);
            Movie newMovie = new Movie(i, "urlMovie" + number, "Movie" + number, "genre" + number);
            manager.add(newMovie);
            expectedMovies[i] = newMovie;
        }

        Movie[] actual = manager.findAll();
        Movie[] expected = expectedMovies;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldEmptyMoviesAndFindAll() {

        MovieManager manager = new MovieManager();
        Movie[] actual = manager.findAll();
        Movie[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldViewLastMovies() {

        MovieManager manager = new MovieManager();
        int arraySize = 15;
        Movie[] expectedMovies = new Movie[arraySize];

        // заполнение списка фильмов
        for (int i = 0; i < arraySize; i++) {
            String number = Integer.toString(i);
            Movie newMovie = new Movie(i, "urlMovie" + number, "Movie" + number, "genre" + number);
            manager.add(newMovie);
            expectedMovies[i] = newMovie;
        }

        Movie[] actual = manager.findLast();
        Movie[] expected = {expectedMovies[14], expectedMovies[13], expectedMovies[12], expectedMovies[11], expectedMovies[10], expectedMovies[9], expectedMovies[8], expectedMovies[7], expectedMovies[6], expectedMovies[5]};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldViewConfigLastMovies() {

        MovieManager manager = new MovieManager(3);
        int arraySize = 8;
        Movie[] expectedMovies = new Movie[arraySize];

        // заполнение списка фильмов
        for (int i = 0; i < arraySize; i++) {
            String number = Integer.toString(i);
            Movie newMovie = new Movie(i, "urlMovie" + number, "Movie" + number, "genre" + number);
            manager.add(newMovie);
            expectedMovies[i] = newMovie;
        }

        Movie[] actual = manager.findLast();
        Movie[] expected = {expectedMovies[7], expectedMovies[6], expectedMovies[5]};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldViewWrongConfigLastMovies() {

        MovieManager manager = new MovieManager(10);
        int arraySize = 5;
        Movie[] expectedMovies = new Movie[arraySize];

        // заполнение списка фильмов
        for (int i = 0; i < arraySize; i++) {
            String number = Integer.toString(i);
            Movie newMovie = new Movie(i, "urlMovie" + number, "Movie" + number, "genre" + number);
            manager.add(newMovie);
            expectedMovies[i] = newMovie;
        }

        Movie[] actual = manager.findLast();
        Movie[] expected = {expectedMovies[4], expectedMovies[3], expectedMovies[2], expectedMovies[1], expectedMovies[0]};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldMockitoDeleteObject() {

        //Настрока заглушки
        Movie[] returned = {movie1, movie2, movie3};
        doReturn(returned).when(repo).findAll();

        manager.removeById(1);

        Movie[] actual = manager.findAll();
        //Movie[] actual = manager.removeById(1);
        Movie[] expected = {movie1, movie3};

        Assertions.assertArrayEquals(expected, actual);

        verify(repo).findAll();
    }

    @Test
    void shouldDeleteObject() {

        MovieManager manager = new MovieManager();
        int arraySize = 5;
        Movie[] expectedMovies = new Movie[arraySize];

        // заполнение списка фильмов
        for (int i = 0; i < arraySize; i++) {
            String number = Integer.toString(i);
            Movie newMovie = new Movie(i, "urlMovie" + number, "Movie" + number, "genre" + number);
            manager.add(newMovie);
            expectedMovies[i] = newMovie;
        }

        manager.removeById(3);

        Movie[] actual = manager.findAll();
        Movie[] expected = {expectedMovies[0], expectedMovies[1], expectedMovies[2], expectedMovies[4]};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldMockitoDeleteAll() {

        //Настрока заглушки
        Movie[] returned = new Movie[]{movie1, movie2, movie3};
        doReturn(returned).when(repo).findAll();

        manager.removeAll();

        Movie[] actual = manager.findAll();
        Movie[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

        verify(repo).findAll();
    }

    @Test
    void shouldDeleteAllObject() {

        MovieManager manager = new MovieManager();
        int arraySize = 5;
        Movie[] expectedMovies = new Movie[arraySize];

        // заполнение списка фильмов
        for (int i = 0; i < arraySize; i++) {
            String number = Integer.toString(i);
            Movie newMovie = new Movie(i, "urlMovie" + number, "Movie" + number, "genre" + number);
            manager.add(newMovie);
            expectedMovies[i] = newMovie;
        }

        manager.removeAll();

        Movie[] actual = manager.findAll();
        Movie[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
