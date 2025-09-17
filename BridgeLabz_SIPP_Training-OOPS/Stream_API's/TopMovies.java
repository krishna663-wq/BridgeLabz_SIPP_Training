import java.util.*;
import java.util.stream.*;

class Movie {
    String name;
    double rating;
    int year;
    Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
}

public class TopMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Movie A", 8.5, 2023),
                new Movie("Movie B", 9.0, 2024),
                new Movie("Movie C", 7.8, 2022),
                new Movie("Movie D", 8.9, 2024),
                new Movie("Movie E", 9.2, 2023),
                new Movie("Movie F", 8.7, 2024)
        );

        movies.stream()
                .filter(m -> m.year >= 2023)
                .sorted(Comparator.comparingDouble((Movie m) -> m.rating).reversed())
                .limit(5)
                .forEach(m -> System.out.println(m.name + " - " + m.rating));
    }
}
