package ru.netology;

public class Main {
    public static void main(String[] args) {
        Toy toy = new Toy();
        Thread threadUser = new Thread(null, new RunnableUser(toy), "User");
        new Thread(null, new RunnableToy(toy, threadUser), "Toy").start();
        threadUser.start();
    }
}
