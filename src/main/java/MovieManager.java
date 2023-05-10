public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int countOfLastMovies;

    public MovieManager() {
        this.countOfLastMovies = 5;
    }

    public MovieManager(int countOfLastMovies) {
        if (countOfLastMovies > 0) {
            this.countOfLastMovies = countOfLastMovies;
        } else {
            this.countOfLastMovies = 5;
        }
    }

    public void add(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int lengthOfList;
        if (countOfLastMovies > movies.length) {
            lengthOfList = movies.length;
        } else {
            lengthOfList = countOfLastMovies;
        }
        Movie[] result = new Movie[lengthOfList];
        for (int i = 0; i < lengthOfList; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }

}
