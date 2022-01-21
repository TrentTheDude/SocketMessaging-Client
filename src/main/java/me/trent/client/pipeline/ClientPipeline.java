package me.trent.client.pipeline;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.UnorderedThreadPoolEventExecutor;

public class ClientPipeline extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();

        //pipeline.addLast("idleStateHandler", new IdleStateHandler());
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());

       // pipeline.addLast("handler", new ClientPipelineHandler());

        UnorderedThreadPoolEventExecutor executorGroup = new UnorderedThreadPoolEventExecutor(2);
        pipeline.addLast(executorGroup, new StringPipelineHandler());
    }
}
