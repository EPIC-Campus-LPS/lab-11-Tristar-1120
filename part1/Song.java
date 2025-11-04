package part1;

public class Song {
    private final String title;
    private final String artist;
    private final int releaseYear;

    public Song(String title, String artist, int releaseYear) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + releaseYear + ")";
    }
}
