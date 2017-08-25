package nettylr.itcast_03_netty.sendorder.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * ? ���ӷ����� ? д���ݵ������� ? �ȴ����ܷ�����������ͬ������ ? �ر�����
 * 
 * @author wilson
 *
 */
public class EchoClient {

	private final String host;
	private final int port;

	public EchoClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void start() throws Exception {
		EventLoopGroup nioEventLoopGroup = null;
		try {
			// �ͻ���������
			Bootstrap bootstrap = new Bootstrap();
			// EventLoopGroup�������Ϊ��һ���̳߳أ�����̳߳������������ӡ��������ݡ���������
			nioEventLoopGroup = new NioEventLoopGroup();
			bootstrap.group(nioEventLoopGroup)//���̴߳���
					.channel(NioSocketChannel.class)//ָ��ͨ������ΪNioServerSocketChannel��һ���첽ģʽ��OIO����ģʽΪOioServerSocketChannel
					.remoteAddress(new InetSocketAddress(host, port))//��ַ
					.handler(new ChannelInitializer<SocketChannel>() {//ҵ������
								@Override
								protected void initChannel(SocketChannel ch)
										throws Exception {
									ch.pipeline().addLast(new EchoClientHandler());//ע��handler
								}
							});
			// ���ӷ�����
			ChannelFuture channelFuture = bootstrap.connect().sync();
			channelFuture.channel().closeFuture().sync();
		} finally {
			nioEventLoopGroup.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws Exception {
		new EchoClient("localhost", 20000).start();
	}
}
