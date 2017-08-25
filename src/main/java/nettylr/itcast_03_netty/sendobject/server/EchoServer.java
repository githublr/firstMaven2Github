package nettylr.itcast_03_netty.sendobject.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import nettylr.itcast_03_netty.sendobject.coder.PersonDecoder;

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
			//����ServerBootstrapʵ���������󶨺�����������
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			//����NioEventLoopGroup�����������¼�������������ӡ��������ݡ�д���ݵȵ�
			eventLoopGroup = new NioEventLoopGroup();
			//ָ��ͨ������ΪNioServerSocketChannel��һ���첽ģʽ��OIO����ģʽΪOioServerSocketChannel
			//����InetSocketAddress�÷���������ĳ���˿��ѵȴ��ͻ������ӡ�
			serverBootstrap.group(eventLoopGroup).channel(NioServerSocketChannel.class).localAddress("localhost",port)
			.childHandler(new ChannelInitializer<Channel>() {
				//����childHandlerִ�����е���������
				@Override
				protected void initChannel(Channel ch) throws Exception {
					//ע������handler
                    ch.pipeline().addLast(new PersonDecoder());  //IN1  �����л�
					//���һ����վ��handler��ChannelPipeline  
					ch.pipeline().addLast(new EchoServerHandler());   //IN2
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
