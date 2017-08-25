package nettylr.itcast_03_netty.sendobject.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import nettylr.itcast_03_netty.sendobject.bean.Person;
import nettylr.itcast_03_netty.sendobject.utils.ByteObjConverter;

/**
 * ���л�
 * ��objectת����Byte[]
 * @author wilson
 *
 */
public class PersonEncoder extends MessageToByteEncoder<Person> {

   @Override
   protected void encode(ChannelHandlerContext ctx, Person msg, ByteBuf out) throws Exception {
       //�����ࣺ��objectת��Ϊbyte[]
       byte[] datas = ByteObjConverter.objectToByte(msg);
       out.writeBytes(datas);
       ctx.flush();
   }
}
