public class BookshelfCupboard extends CupBoard {
    @Override
    public void open() {
        System.out.println("Bookshelf cupboard is being opened.");
    }

    public BookshelfCupboard(int capacity) {
        super(capacity);
    }
}
