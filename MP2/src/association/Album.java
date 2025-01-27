package association;

public class Album {
    private String name;
    private int numberOfSongs;

    private Artist artist;

    public Album(String name, int numberOfSongs) {
        this.name = name;
        this.numberOfSongs = numberOfSongs;
    }

    public Album(String name, int numberOfSongs, Artist artist) {
        this.name = name;
        this.numberOfSongs = numberOfSongs;
        setArtist(artist);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        if (this.artist == artist) {
            return;
        }

        if (this.artist != null) {
            this.artist.removeAlbum(this);
        }

        this.artist = artist;

        if (artist != null) {
            artist.addAlbum(this);
        }
    }

    @Override
    public String toString() {
        return "Album - " + this.name + " was written by [" + this.artist.getRealName() + " (" + this.artist.getStageName() + ")" +
                "] and contains " + this.numberOfSongs + " songs";
    }
}
