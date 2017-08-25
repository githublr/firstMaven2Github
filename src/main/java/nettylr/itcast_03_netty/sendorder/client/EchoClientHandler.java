package nettylr.itcast_03_netty.sendorder.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
	// �ͻ������ӷ������󱻵���
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("�ͻ������ӷ���������ʼ�������ݡ���");
		byte[] req = "QUERY TIME ORDER".getBytes();//��Ϣ
		ByteBuf firstMessage = Unpooled.buffer(req.length);//������
		firstMessage.writeBytes(req);//����
		ctx.writeAndFlush(firstMessage);//flush
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
