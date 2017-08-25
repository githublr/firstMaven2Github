package nettylr.itcast_03_netty.sendobject.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import nettylr.itcast_03_netty.sendobject.bean.Person;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
	// �ͻ������ӷ������󱻵���
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		 Person person = new Person();
	        person.setName("angelababy");
	        person.setSex("girl");
	        person.setAge(18);
	        ctx.write(person);
	        ctx.flush();
	}

	// ? �ӷ��������յ����ݺ����
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg)
			throws Exception {
		System.out.println("client ��ȡserver����..");
		// ����˷�����Ϣ��
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println("���������Ϊ :" + body);
	}

	// ? �����쳣ʱ������
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		System.out.println("client exceptionCaught..");
		// �ͷ���Դ
		ctx.close();
	}
}
