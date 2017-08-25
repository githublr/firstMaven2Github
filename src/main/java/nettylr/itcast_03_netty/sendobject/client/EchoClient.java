package nettylr.itcast_03_netty.sendobject.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import nettylr.itcast_03_netty.sendobject.coder.PersonEncoder;

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
			// ����Bootstrap�����������������ͻ���
			Bootstrap bootstrap = new Bootstrap();
			// ����EventLoopGroup�������õ�Bootstrap�У�EventLoopGroup�������Ϊ��һ���̳߳أ�����̳߳������������ӡ��������ݡ���������
			nioEventLoopGroup = new NioEventLoopGroup();
			// ����InetSocketAddress�����õ�Bootstrap�У�InetSocketAddress��ָ�����ӵķ�������ַ
			bootstrap.group(nioEventLoopGroup)//
					.channel(NioSocketChannel.class)//
					.remoteAddress(new InetSocketAddress(host, port))//
					.handler(new ChannelInitializer<SocketChannel>() {//
								// ���һ��ChannelHandler���ͻ��˳ɹ����ӷ�������ͻᱻִ��
								@Override
								protected void initChannel(SocketChannel ch)
										throws Exception {
									// ע������handler
									ch.pipeline().addLast(new PersonEncoder());  //out
									//ע�ᴦ����Ϣ��handler
									ch.pipeline().addLast(new EchoClientHandler());   //in
								}
							});
			// ? ����Bootstrap.connect()�����ӷ�����
			ChannelFuture f = bootstrap.connect().sync();
			// ? ���ر�EventLoopGroup���ͷ���Դ
			f.channel().closeFuture().sync();
		} finally {
			nioEventLoopGroup.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws Exception {
		new EchoClient("localhost", 20000).start();
	}
}
