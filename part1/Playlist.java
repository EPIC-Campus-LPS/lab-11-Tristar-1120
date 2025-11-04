package part1;

public class Playlist {
    private final String name;
    private final Song[] songs;

    public Playlist(String name, Song[] songs) {
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public Song[] getSongs() {
        return songs;
    }
}
