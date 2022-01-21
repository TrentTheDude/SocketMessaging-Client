package me.trent.client.request;

import io.netty.channel.Channel;
import me.trent.client.Storage;
import me.trent.client.eums.DataType;
import me.trent.client.eums.MessageType;

public class ClientRequest implements RequestI {

    private DataType dataType;
    private MessageType messageType;
    private Object data;
    private Channel channel;

    public ClientRequest(Channel channel, DataType dataType, MessageType messageType, Object data){
        this.dataType = dataType;
        this.messageType = messageType;
        this.data = data;
        this.channel = channel;

        Storage.clientRequestList.add(this);
    }

    @Override
    public void sendRequest() {

    }

    @Override
    public void delete() {
        Storage.clientRequestList.remove(this);
    }

    @Override
    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    @Override
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }
    @Override
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }


    @Override
    public DataType getDataType() {
        return dataType;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public Object getData() {
        return data;
    }
}
