import java.util.Objects;

public class Key implements PianoComponent {
    private String note;

    public Key(String note) {
        this.note = note;
    }

    @Override
    public void press() {
        System.out.println("Key " + note + " is pressed.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Objects.equals(note, key.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note);
    }

    @Override
    public String toString() {
        return "Key{" +
                "note='" + note + '\'' +
                '}';
    }
}