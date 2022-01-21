package me.trent.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import me.trent.client.eums.DataType;
import me.trent.client.eums.MessageType;
import me.trent.client.exceptions.InvalidChannelException;
import me.trent.client.utils.Utils;
import me.trent.client.pipeline.ClientPipeline;
import me.trent.client.request.ClientRequest;

public class Client {

    private String server;
    private String name;
    private int port;
    private int containerPort;
    private boolean alive = false;
    private Channel channel;

    public Client(String server, int port, int containerPort, String name) {
        this.server = server;
        this.port = port;
        this.containerPort = containerPort;
        this.name = name;
    }

    public void start() {
        Utils.log("Starting Client...");
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap().group(group)
                    .channel(NioSocketChannel.class)
                    //.option(ChannelOption.AUTO_READ, true)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ClientPipeline());


            channel = bootstrap.connect(getServer(), getPort()).sync().channel();
            Utils.log("Client: "+getName()+" has Started!");
            setAlive(true); // alive

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //group.shutdownGracefully(); todo; find a better way of controlling closing the program...
        }
    }

    public Channel getChannel() {
        return channel;
    }

    public void sendMessage(Channel channel, DataType dataType, MessageType messageType, Object data) throws InvalidChannelException {
        new ClientRequest(channel, dataType, messageType, data).sendRequest();
    }


    public int getPort() {
        return port;
    }

    public String getName() {
        return name;
    }

    public String getServer() {
        return server;
    }

    public int getContainerPort() {
        return containerPort;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
