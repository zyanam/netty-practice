package com.yanam.example.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DiscardClientHandler extends SimpleChannelInboundHandler<Object> {
   private ByteBuf content;
   private ChannelHandlerContext ctx;

   @Override
   public void channelActive(ChannelHandlerContext ctx){
      this.ctx = ctx;

      content = ctx.alloc().directBuffer(DiscardClient.SIZE).writeZero(DiscardClient.SIZE);
   }

   @Override
   public void channelInactive(ChannelHandlerContext ctx){content.release();}

   @Override
   public void channelRead0(ChannelHandlerContext ctx,Object msg) throws Exception {

   }
}
