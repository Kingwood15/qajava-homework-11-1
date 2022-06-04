package ru.netology.manager.MovieManager;

import lombok.AllArgsConstructor;
import lombok.Data;

//@AllArgsConstructor
@Data
public class MovieManager {

    private MoviesRepo repo = new MoviesRepo();

    public MovieManager() {

        repo.setNumberLastMovies(10);
        repo.findAll();
    }

    public MovieManager(int numberLastMovies) {

        repo.setNumberLastMovies(numberLastMovies);
        repo.findAll();

    }

    //принимает репозиторий от Mokito
    public MovieManager(MoviesRepo repoForMockito) {

        repo.setNumberLastMovies(10);
        this.repo = repoForMockito;

    }

    public void add(Movie newMovie) {

        repo.save(newMovie);
    }

    public Movie[] findAll() {

        return repo.findAll();
    }

    public Movie[] findLast() {

        if (repo.getNumberLastMovies() < repo.getMovies().length) {

            Movie[] result = new Movie[repo.getNumberLastMovies()];

            //заполняем массив в обратном порядке
            for (int i = 0; i < result.length; i++) {
                int index = repo.getMovies().length - i - 1;
                result[i] = repo.findById(index);
            }

            return result;

        } else {

            Movie[] result = new Movie[repo.getMovies().length];

            //заполняем массив в обратном порядке
            for (int i = 0; i < result.length; i++) {
                int index = repo.getMovies().length - i - 1;
                result[i] = repo.findById(index);
            }

            return result;
        }
    }

    public Movie[] removeById(int removeId) {

        return repo.removeById(removeId);

    }

    public Movie[] removeAll() {

        return repo.removeAll();

    }
}
