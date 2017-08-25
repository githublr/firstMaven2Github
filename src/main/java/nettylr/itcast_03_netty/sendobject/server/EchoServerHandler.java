package nettylr.itcast_03_netty.sendobject.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import nettylr.itcast_03_netty.sendobject.bean.Person;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		Person person = (Person) msg;
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getSex());
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("server ��ȡ�������..");
        ctx.flush();//ˢ�º�Ž����ݷ�����SocketChannel
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
