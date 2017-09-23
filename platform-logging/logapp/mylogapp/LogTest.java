package mylogapp;

public class LogTest {
    public static void main(String[] args) {
        System.getLogger("MyLogger").log(System.Logger.Level.INFO, "This is a test.");
    }
}
