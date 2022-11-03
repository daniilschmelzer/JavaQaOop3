import model.Film;

interface FilmManager {
    void addFilm(Film film);
    Film[] findAll();
    Film[] findLast();
}
