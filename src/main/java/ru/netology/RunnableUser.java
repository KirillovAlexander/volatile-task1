package ru.netology;

public class RunnableUser implements Runnable {

    private static final int TIMER = 2000;
    private static final int AMOUNT_OF_GAMES = 5;

    private Toy toy;

    public RunnableUser(Toy toy) {
        this.toy = toy;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < AMOUNT_OF_GAMES; i++) {
                Thread.sleep(TIMER);
                toy.setFlag(true);
                System.out.println(Thread.currentThread().getName() + " включаю тумблер!");
            }
            Thread.sleep(TIMER);
            System.out.println(Thread.currentThread().getName() + " надоело играть, ухожу.");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
