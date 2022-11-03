import lombok.RequiredArgsConstructor;
import model.Film;

import java.util.*;
import java.util.stream.Collectors;

public class FilmManagerImpl implements FilmManager {

    private final int capacity;
    private int counter;
    private final int limit;
    private Film[] films;

    public FilmManagerImpl() {
        this.capacity = 15;
        this.films = new Film[capacity];
        this.limit = 10;
    }

    public FilmManagerImpl(int capacity) {
        this.capacity = capacity;
        this.counter = 0;
        this.limit = 10;
        this.films = new Film[this.capacity];
    }

    public FilmManagerImpl(int capacity, int limit) {
        this.capacity = capacity;
        this.counter = 0;
        this.limit = limit;
        this.films = new Film[this.capacity];
        if (limit > capacity) {
            throw new IllegalArgumentException("Limit shouldn't be grater than capacity");
        }
    }

    @Override
    public void addFilm(Film film) {
        if (counter <= films.length - 1) {
            films[counter] = film;
        } else {
            System.out.println("enough films");
        }

        counter++;
    }

    @Override
    public Film[] findAll() {
        List<Film> filmsList = Arrays.asList(films);
        List<Film> resulList = filmsList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return resulList.toArray(new Film[counter]);
    }

    @Override
    public Film[] findLast() {
        List<Film> orderedFilms = Arrays.asList(films);
        Collections.reverse(orderedFilms);
        List<Film> resulList = orderedFilms.stream()
                .filter(Objects::nonNull)
                .limit(limit)
                .collect(Collectors.toList());

        return resulList.toArray(new Film[limit]);
    }

}
