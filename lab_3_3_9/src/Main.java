public class Main {
    public static void main(String[] args) {
        PhotoAlbum album = new PhotoAlbum();

        album.addPhoto(new Photo("Summer Vacation"));
        album.addPhoto(new Photo("Family Reunion"));
        album.addPhoto(new Photo("Birthday Party"));

        album.printNumberOfPhotos();
    }
}