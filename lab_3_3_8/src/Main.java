public class Main {
    public static void main(String[] args) {
        Key key1 = new Key("C2");
        Key key2 = new Key("D1");
        Key key3 = new Key("E0");

        Piano piano = new Piano();
        piano.addKey(key1);
        piano.addKey(key2);
        piano.addKey(key3);

        piano.press();
    }
}