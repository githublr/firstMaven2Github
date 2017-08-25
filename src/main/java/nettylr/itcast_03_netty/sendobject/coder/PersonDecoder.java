package nettylr.itcast_03_netty.sendobject.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import nettylr.itcast_03_netty.sendobject.utils.ByteBufToBytes;
import nettylr.itcast_03_netty.sendobject.utils.ByteObjConverter;

import java.util.List;

/**
 * �����л�
 * ��Byte[]ת��ΪObject
 * @author wilson
 *
 */
public class PersonDecoder extends ByteToMessageDecoder {
   @Override
   protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
       //�����ࣺ��ByteBufת��Ϊbyte[]
       ByteBufToBytes read = new ByteBufToBytes();
       byte[] bytes = read.read(in);
       //�����ࣺ��byte[]ת��Ϊobject
       Object obj = ByteObjConverter.byteToObject(bytes);
       out.add(obj);
   }

}
