import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class MovieManagerTest {

    Movie movie1 = new Movie(1, "Бладшот", "боевик");
    Movie movie2 = new Movie(2, "Вперёд", "мультфильм");
    Movie movie3 = new Movie(3, "Отель «Белград»", "комедия");
    Movie movie4 = new Movie(4, "Джентльмены", "боевик");
    Movie movie5 = new Movie(5, "Человек-неведимка", "ужасы");
    Movie movie6 = new Movie(6, "Тролли. Мировой тур", "мультфильм");
    Movie movie7 = new Movie(7, "Номер один", "комедия");

    @Test
    public void shouldAddOneMovie() {
        MovieManager manager = new MovieManager();
        manager.add(movie1);

        Movie[] expected = {movie1};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSeveralMovie() {
        MovieManager manager = new MovieManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] expected = {movie1, movie2, movie3};
        Movie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithNoParam() {
        MovieManager manager = new MovieManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        Movie[] expected = {movie7, movie6, movie5, movie4, movie3};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastWithParam() {
        MovieManager manager = new MovieManager(4);
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        Movie[] expected = {movie7, movie6, movie5, movie4};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLast5IfNegativeParam() {
        MovieManager manager = new MovieManager(-4);
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        Movie[] expected = {movie7, movie6, movie5, movie4, movie3};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastIfNotEnoughMovies() {
        MovieManager manager = new MovieManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);

        Movie[] expected = {movie4, movie3, movie2, movie1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
