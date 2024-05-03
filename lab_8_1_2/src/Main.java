class Robot extends Thread {
    private String direction;

    public Robot(String direction) {
        this.direction = direction;
    }

    @Override
    public void run() {
        walk();
    }

    public void walk() {
        System.out.println(Thread.currentThread().getName() + " starts walking " + direction);

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " steps " + direction);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(Thread.currentThread().getName() + " finishes walking " + direction);
    }
}

public class Main extends Thread {

    public static void main(String[] args) {
        Robot leftLeg = new Robot("LEFT");
        Robot rightLeg = new Robot("RIGHT");

        leftLeg.start();
        rightLeg.start();
    }
}
