import model.Film;
import org.junit.jupiter.api.Test;

public class FilmManagerImplTest {

    FilmManager filmManager = new FilmManagerImpl(5, 2);

    @Test
    public void findAllTest() {
        filmManager.addFilm(new Film("Крепкий орешек","Боевик"));
        filmManager.addFilm(new Film("Легенда","Боевик"));
        filmManager.addFilm(new Film("Круэлла","Фэнтази"));
        Film[] films = filmManager.findAll();
        for (Film film : films) {
            System.out.println(film);
        }
    }

    @Test
    public void findLastTest() {
        filmManager.addFilm(new Film("Крепкий орешек","Боевик"));
        filmManager.addFilm(new Film("Легенда","Боевик"));
        filmManager.addFilm(new Film("Круэлла","Фэнтази"));
        filmManager.addFilm(new Film("Робин Гуд","Приключения"));
        filmManager.addFilm(new Film("Звездные войны","Фэнтази"));
        Film[] films = filmManager.findLast();
        for (Film film : films) {
            System.out.println(film);
        }
    }
}