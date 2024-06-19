import java.util.ArrayList;

public class PhotoAlbum {
    private ArrayList<Photo> photos = new ArrayList<>();

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    public void printNumberOfPhotos() {
        System.out.println("Number of photos in the album: " + photos.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoAlbum that = (PhotoAlbum) o;
        return photos.equals(that.photos);
    }

    @Override
    public int hashCode() {
        return photos.hashCode();
    }

    @Override
    public String toString() {
        return "PhotoAlbum{" +
                "photos=" + photos +
                '}';
    }
}
