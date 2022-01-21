package me.trent.client.request;

import io.netty.channel.Channel;
import me.trent.client.eums.DataType;
import me.trent.client.eums.MessageType;


public interface RequestI {

    public void sendRequest();

    public void delete();

    public void setDataType(DataType dataType);
    public void setMessageType(MessageType messageType);
    public void setData(Object data);
    public void setChannel(Channel channel);

    public DataType getDataType();
    public Channel getChannel();

    public MessageType getMessageType();

    public Object getData();

}
