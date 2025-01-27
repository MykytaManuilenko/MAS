package association;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String stageName;
    private String realName;

    private List<Album> albums = new ArrayList<>();

    public Artist(String stageName, String realName) {
        this.stageName = stageName;
        this.realName = realName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<Album> getAlbums() {
        return new ArrayList<>(albums);
    }

    public void addAlbum(Album album) {
        if (album == null) {
            throw new NullPointerException("Album can not be null");
        } else if (!albums.contains(album)) {
            albums.add(album);
            album.setArtist(this);
        }
    }

    public void removeAlbum(Album album) {
        if (albums.contains(album)) {
            albums.remove(album);
            album.setArtist(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Artist " + this.realName + " (" + this.stageName + ") wrote albums:\n");

        for (Album a : albums) {
            info.append(" ").append(a.getName()).append("\n");
        }

        return info.toString();
    }
}
