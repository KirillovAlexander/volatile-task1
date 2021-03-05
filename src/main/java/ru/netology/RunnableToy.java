package ru.netology;

public class RunnableToy implements Runnable{
    private static final int TIME_TO_TURN_OFF = 500;
    private Toy toy;
    private Thread threadUser;

    public RunnableToy(Toy toy, Thread threadUser) {
        this.toy = toy;
        this.threadUser = threadUser;
    }

    @Override
    public void run() {
        while (threadUser.isAlive()) {
            if (toy.isFlag()) {
                try {
                    Thread.sleep(TIME_TO_TURN_OFF);
                    toy.setFlag(false);
                    System.out.println(Thread.currentThread().getName() + " вЫключаю тумблер!");
                } catch (InterruptedException ex) {
                    return;
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " выключаюсь.");
    }
}
