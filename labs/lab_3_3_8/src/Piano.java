import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Piano implements PianoComponent {
    private List<PianoComponent> keys = new ArrayList<>();

    public void addKey(PianoComponent key) {
        keys.add(key);
    }

    public void tune() {
        System.out.println("Piano is tuned.");
    }

    public void play() {
        System.out.println("Playing the piano.");
    }

    @Override
    public void press() {
        System.out.println("Playing the piano.");
        for (PianoComponent key : keys) {
            key.press();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piano piano = (Piano) o;
        return piano.keys.equals(this.keys);
    }

    @Override
    public int hashCode() {
        return this.keys.hashCode();
    }

    @Override
    public String toString() {
        return "Piano{" +
                "keys=" + this.keys.toString() +
                '}';
    }
}
