package week3muziek;

import java.util.Collection;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
public class MyMusicPlayer implements MusicPlayer {
    HashMap<String, Song> songCollection;
    Deque<Song> playlist;
    HashSet<String> playedSongs;
    private int totalPlayed = 0;

    public MyMusicPlayer(){
        this.songCollection = new HashMap<>();
        this.playlist = new ArrayDeque<>();
        this.playedSongs = new HashSet<>();
    }
    @Override
    public int addSongs(Collection<Song> songs) {

        int total = 0;
        for(Song song : songs){
            if(!this.songCollection.containsKey(song.getName())) {
                this.songCollection.put(song.getName(), song);
                total++;
            }
        }
        return total;
    }


    @Override
    public boolean queueNext(String songName) {
        if(this.songCollection.containsKey(songName)){
            this.playlist.addFirst(this.songCollection.get(songName));
            return true;
        }
        return false;
    }

    @Override
    public boolean queueLast(String songName) {
        if(this.songCollection.containsKey(songName)){
            this.playlist.addLast(this.songCollection.get(songName));
            return true;
        }
        return false;
    }

    @Override
    public Song playNext() {
        if(this.playlist.size()>0){
            Song playedSong = this.playlist.poll();
            totalPlayed += playedSong.getDuration();
            this.playedSongs.add(playedSong.getName());
            return playedSong;
        }
        return null;
    }

    @Override
    public boolean hasPlayed(String songName) {
        return this.playedSongs.contains(songName);
    }

    @Override
    public int timePlayed() {
        return totalPlayed;
    }
}
