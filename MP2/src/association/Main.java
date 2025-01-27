package association;

public class Main {
    public static void main(String[] args) {
        // 1 Artist - * Albums
        Artist artist = new Artist("50 Cent", "Curtis James Jackson III");

        Album album1 = new Album("Get Rich or Die Tryin", 10);
        Album album2 = new Album("Curtis", 12);

        artist.addAlbum(album1);
        artist.addAlbum(album2);

        album1.setArtist(artist);

        Album album3 = new Album("Before I Self Destruct", 15, artist);

        System.out.println(artist + "\n");
        System.out.println(album1);

        System.out.println("\n============After deleting one album============");
        artist.removeAlbum(album1);
        System.out.println(artist + "\n");
    }
}
