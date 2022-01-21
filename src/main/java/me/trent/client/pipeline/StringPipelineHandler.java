package me.trent.client.pipeline;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.trent.client.Utils;

public class StringPipelineHandler extends
        SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String message) throws Exception {
        Utils.log(message);

        //check who the message is from...




        //todo; handle these messages with purpose...
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


    //@Override
    //public void channelRead(ChannelHandlerContext arg0, Object arg1)
    //        throws Exception {
    //    Utils.log("channel-Read");
    //    // TODO Auto-generated method stub
    //}

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[SYSTEM] Connected to the Server!");
       // channels.add(ctx.channel());
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[SYSTEM] Lost Connection to the Server!");
        //channels.remove(ctx.channel());
        super.handlerRemoved(ctx);
    }



    //@Override
    //public void channelReadComplete(ChannelHandlerContext arg0)
    //        throws Exception {
    //    // TODO Auto-generated method stub
    //    Utils.log("channelReadComplete");
    //}

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext arg0)
            throws Exception {
        // TODO Auto-generated method stub
        Utils.log("channelWritabilityChanged");

    }

}
