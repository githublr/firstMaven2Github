package nettylr.itcast_03_netty.sendorder.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * ? ���÷��������ܣ����̡߳��˿� ? ʵ�ַ������������������ҵ���߼�����������һ���������ӻ��������ʱ����ʲô
 * 
 * @author wilson
 *
 */
public class EchoServer {

	private final int port;

	public EchoServer(int port) {
		this.port = port;
	}

	public void start() throws Exception {
		EventLoopGroup eventLoopGroup = null;
		try {
			//server��������
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			//���ӳش�������
			eventLoopGroup = new NioEventLoopGroup();
			serverBootstrap.group(eventLoopGroup)
			.channel(NioServerSocketChannel.class)//ָ��ͨ������ΪNioServerSocketChannel��һ���첽ģʽ��OIO����ģʽΪOioServerSocketChannel
			.localAddress("localhost",port)//����InetSocketAddress�÷���������ĳ���˿��ѵȴ��ͻ������ӡ�
			.childHandler(new ChannelInitializer<Channel>() {//����childHandlerִ�����е���������
				@Override
				protected void initChannel(Channel ch) throws Exception {
					// ע������InboundHandler��ִ��˳��Ϊע��˳������Ӧ����InboundHandler1 InboundHandler2
					// ע������OutboundHandler��ִ��˳��Ϊע��˳�����������Ӧ����OutboundHandler2 OutboundHandler1
					ch.pipeline().addLast(new EchoInHandler1());
					ch.pipeline().addLast(new EchoInHandler2());
					ch.pipeline().addLast(new EchoOutHandler1());
					ch.pipeline().addLast(new EchoOutHandler2()); 
					
				}
					});
			// ���󶨷������ȴ�ֱ������ɣ�����sync()����������ֱ����������ɰ�,Ȼ��������ȴ�ͨ���رգ���Ϊʹ��sync()�����Թرղ���Ҳ�ᱻ������
			ChannelFuture channelFuture = serverBootstrap.bind().sync();
			System.out.println("��ʼ�������˿�Ϊ��" + channelFuture.channel().localAddress());
			channelFuture.channel().closeFuture().sync();
		} finally {
			eventLoopGroup.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws Exception {
		new EchoServer(20000).start();
	}
}
