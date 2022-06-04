package ru.netology.manager.MovieManager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoviesRepo {

    private Movie[] movies = new Movie[0];
    private int numberLastMovies;

    //findAll - возвращает массив всех хранящихся в массиве объектов
    public Movie[] findAll() {

        return movies;
    }

    //save - добавляет объект в массив
    public void save(Movie newMovie) {

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

    //findById - возвращает объект по идентификатору (либо null, если такого объекта нет)
    public Movie findById(int findId) {

        Movie findObject = new Movie();

        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getId() == findId) {
                findObject = movies[i];
            }
        }

        return findObject;
    }

    //removeById - удаляет объект по идентификатору (если объекта нет, то пусть будет исключение, как на лекции)
    public Movie[] removeById(int removeId) {

        if (movies.length != 0) {
            Movie[] tmp = new Movie[movies.length - 1];
            int copyToIndex = 0;

            for (int i = 0; i < movies.length; i++) {
                if (movies[i].getId() != removeId) {
                    tmp[copyToIndex] = movies[i];
                    copyToIndex++;
                }
            }

            movies = tmp;
        }
        return movies;
    }

    //removeAll* - полностью вычищает репозиторий (для удаления всех элементов достаточно в поле items положить пустой массив)
    public Movie[] removeAll() {

        Movie[] newMovies = new Movie[0];
        movies = newMovies;
        return movies;
    }
}
