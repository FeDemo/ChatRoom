package socketDemo;
import java.awt.Frame;
import java.net.*;
import util.*;
public class Rece extends Thread{
	
	public  void run(){
		DatagramSocket ds=null;
		try {
			ds=new DatagramSocket(10001);//端口号
			while(true){
				byte[] buf=new byte[1024];
				//构造数据报包
				DatagramPacket dp=new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				String data=new String(dp.getData(),0,dp.getLength());//返回数据包
				Constant.show.append(data+"\n");
				if (Constant.l.getExtendedState()==1) {//唤醒最小化的窗口
					Constant.l.setExtendedState(Frame.NORMAL);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (ds!=null) {
				ds.close();
			}
		}
	}
}
