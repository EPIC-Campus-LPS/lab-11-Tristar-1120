package part1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class myMusic {
    public static void main(String[] args) throws IOException{
        Scanner fileScanner = new Scanner(new File("playlist.txt"));
        Playlist[] playlists = new Playlist[10];
        for (int i =0, n = 10; i < n; i++) {
            String name = fileScanner.nextLine();
            Song[] songs = new Song[5];
            for (int j = 0; j < songs.length; j++) {
                String songLine = fileScanner.nextLine();
                String[] songData = songLine.split(", ");
                String title = songData[0];
                String artist = songData[1];
                int releaseYear = Integer.parseInt(songData[2]);
                songs[j] = new Song(title, artist, releaseYear);
                System.out.println(songs[j].toString());
            }
            playlists[i] = new Playlist(name, songs);
            fileScanner.nextLine();
        }
        Scanner i = new Scanner(System.in);
        System.out.println("_______________________________");
        System.out.println("Playlist Viewer Menu\n(A) View list of Playlists\n(B) View a Playlist\n(C) Search Songs\n(D) Exit\n");
        System.out.print("Select a mode: ");
        String mode = i.nextLine();

        if (mode.toLowerCase().equals("a")) {
            System.out.println("Playlists:");
            for (Playlist p : playlists) {
                System.out.println(p.getName());
                Song[] listSongs = p.getSongs();
                for (Song s : listSongs) {
                    System.out.println(" - " + s.toString());
                }
                System.out.println("");
            }
        }
        else if (mode.toLowerCase().equals("b")) {
            System.out.print("Which playlist would you like to view? ");
            int playlistID = i.nextInt();
            Playlist playlist = playlists[playlistID - 1];
            System.out.println(playlist.getName());
            Song[] listSongs = playlist.getSongs();
            for (Song s : listSongs) {
                System.out.println(" - " + s.toString());
            }

        } 
        else if (mode.toLowerCase().equals("c")) {
            System.out.print("What would you like to search by? \n(A) Artist\n(B) Release Year\n");
            String searchMode = i.nextLine();
            if (searchMode.toLowerCase().equals("a")) {
                System.out.print("Enter artist name: ");
                String artistName = i.nextLine();
                System.out.println("Songs by " + artistName + ":");
                for (Playlist p : playlists) {
                    Song[] listSongs = p.getSongs();
                    for (Song s : listSongs) {
                        if (s.getArtist().equalsIgnoreCase(artistName)) {
                            System.out.println(" - " + s.toString());
                        }
                    }
                }
            } 
            else if (searchMode.toLowerCase().equals("b")) {
                System.out.print("Enter release year: ");
                int releaseYear = i.nextInt();
                System.out.println("Songs released in " + releaseYear + ":");
                for (Playlist p : playlists) {
                    Song[] listSongs = p.getSongs();
                    for (Song s : listSongs) {
                        if (s.getReleaseYear() == releaseYear) {
                            System.out.println(" - " + s.toString());
                        }
                    }
                }
            } 
            else {
                System.out.println("Invalid search mode selected.");
            }
        } 
        else if (mode.toLowerCase().equals("d")) {
            System.out.println("Exiting Playlist Viewer. Goodbye!");
        } 
        else {
            System.out.println("Invalid mode selected.");
        }
    }
}