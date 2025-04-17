class Movie {
    String title;
    String director;
    int year;
    double ratiing;
    Movie prev = null;
    Movie next = null;

    public Movie(String title, String director, int year, double ratiing) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.ratiing = ratiing;
    }
}

class MovieList {
    static Movie start = null;
    static Movie tail = null;

    public void insertAtBegin(Movie movie) {
        if (start == null) {
            start = tail = movie;
        } else {
            movie.next = start;
            start.prev = movie;
            start = movie;
        }
    }

    public void insertAtEnd(Movie movie) {
        if (tail == null) insertAtBegin(movie);
        else {
            tail.next = movie;
            movie.prev = tail;
            tail = movie;
        }
    }

    public void insertAtPos(Movie movie, int pos) {
        if (start == null || pos <= 1) {
            insertAtBegin(movie);
            return;
        }

        Movie temp = start;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            insertAtEnd(movie);
        } else {
            movie.next = temp.next;
            movie.prev = temp;
            temp.next.prev = movie;
            temp.next = movie;
        }
    }

    public void searchByDirector(String directorName) {
        Movie temp = start;
        while (temp != null) {
            if (directorName.equalsIgnoreCase(temp.director)) {
                System.out.println("movie name: " + temp.title);
                System.out.println("release date: " + temp.year);
            }
            temp = temp.next;
        }
    }

    public void searchByRating(double movieRating) {
        Movie temp = start;
        while (temp != null) {
            if (movieRating == temp.ratiing) {
                System.out.println("movie name: " + temp.title);
                System.out.println("release date: " + temp.year);
            }
            temp = temp.next;
        }
    }

    public void updateRating(String movieName, double newRating) {
        Movie temp = start;
        while (temp != null && !(movieName.equalsIgnoreCase(temp.title))) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("required movie name not found");
        } else {
            temp.ratiing = newRating;
        }
    }

    public void removeRecord(String movieName) {
        Movie temp = start;
        while (temp != null && !(movieName.equalsIgnoreCase(temp.title))) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("required movie name not found");
        } else {
            if (temp == start) {
                start = start.next;
                if (start != null) start.prev = null;
            } else if (temp == tail) {
                tail = tail.prev;
                if (tail != null) tail.next = null;
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
    }

    public void displayMovieForward() {
        Movie temp = start;
        while (temp != null) {
            System.out.println("movie name: " + temp.title);
            System.out.println("release date: " + temp.year);
            System.out.println("director: " + temp.director);
            System.out.println("ratiing: " + temp.ratiing);
            temp = temp.next;
        }
    }

    public void displayMovieReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println("movie name: " + temp.title);
            System.out.println("release date: " + temp.year);
            System.out.println("director: " + temp.director);
            System.out.println("ratiing: " + temp.ratiing);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String args[]) {
        Movie m1 = new Movie("sankranti", "anil", 2024, 4.5);
        Movie m2 = new Movie("rrr", "rajmouli", 2023, 4.5);
        Movie m3 = new Movie("salaar", "ravi", 2023, 4.0);
        Movie m4 = new Movie("krack", "gopi", 2022, 4.5);
        Movie m5 = new Movie("maharaj", "gopi", 2025, 4.0);

        MovieList list = new MovieList();
        list.insertAtBegin(m1);
        list.insertAtBegin(m2);
        list.insertAtEnd(m3);
        list.insertAtEnd(m4);
        list.insertAtPos(m5, 3);

        System.out.println("\nMovies in Forward Order:");
        list.displayMovieForward();

        System.out.println("\nRemoving movie: salaar");
        list.removeRecord("salaar");

        System.out.println("\nSearching movies with rating 4.0:");
        list.searchByRating(4.0);

        System.out.println("\nSearching movies by director 'gopi':");
        list.searchByDirector("gopi");

        System.out.println("\nUpdating rating of movie 'rrr' to 5.0");
        list.updateRating("rrr", 5.0);

        System.out.println("\nMovies in Reverse Order:");
        list.displayMovieReverse();
    }
}
