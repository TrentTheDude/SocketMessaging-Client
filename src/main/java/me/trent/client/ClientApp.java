package me.trent.client;

import me.trent.client.eums.DataType;
import me.trent.client.eums.MessageType;
import me.trent.client.exceptions.InvalidChannelException;
import me.trent.client.utils.FileUtils;
import me.trent.client.utils.Utils;

public class ClientApp {

    public static void main(String... args) throws InvalidChannelException {

        String ip = (String) FileUtils.getValue("config.txt", "server");
        Utils.log("Server-IP: "+ip);

        Client client1 = new Client("127.0.0.1", 6969, 8080, "Client-1");
        client1.start();

        for (int a = 1; a <= 10; a++){
            //client1.sendMessage("Message "+a+" of 10...");
            client1.sendMessage(client1.getChannel(), DataType.STRING, MessageType.MESSAGE, "Message "+a+" of 10 ,., \n");
        }



    }
}
