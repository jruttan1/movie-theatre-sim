public class Movie {
    // instance variables
    private String title;
    private String genre;
    private String rating;
    private double score;
    private String director;
    private String[] actors;
    private int year;

    // Constructor
    public Movie(String title, String genre, int duration, String rating, double score, String director, String[] actors, int year) {
        this.title = title; // this refers to the current object
        this.genre = genre; // implicit parameter "this" is used to refer to the current object
        this.rating = rating;
        this.score = score;
        this.director = director;
        this.actors = actors;
        this.year = year;
    }

    // Methods
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }

    public double getScore() {
        return score;
    }

    public String getDirector() {
        return director;
    }

    public String[] getActors() {
        return actors;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // To String
    public String toString() {
        return title + ": " + year + " by " + director +
                " starring " + actors[0] + " and " + actors[1] +
                " is a " + genre + "film, with a rating of " + rating + ".";
    }


}
