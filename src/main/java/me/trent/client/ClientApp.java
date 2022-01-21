package me.trent.client;

public class ClientApp {

    public static void main(String... args) throws InterruptedException {
        Client client1 = new Client("127.0.0.1", 6969, 8080, "Client-1");
        client1.start();

        for (int a = 1; a <= 10; a++){
            client1.sendMessage("Message "+a+" of 10...");
        }



    }
}
