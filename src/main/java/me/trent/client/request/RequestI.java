package me.trent.client.request;

import io.netty.channel.Channel;
import me.trent.client.eums.DataType;
import me.trent.client.eums.MessageType;
import me.trent.client.exceptions.InvalidChannelException;


public interface RequestI {

    public void sendRequest() throws InvalidChannelException;

    public void delete();

    public void setDataType(DataType dataType);
    public void setMessageType(MessageType messageType);
    public void setData(Object data);
    public void setChannel(Channel channel);
    public void setSent(boolean set);

    public boolean isSent();
    public DataType getDataType();
    public Channel getChannel();

    public MessageType getMessageType();

    public Object getData();

}
