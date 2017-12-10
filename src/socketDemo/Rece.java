package socketDemo;
import java.awt.Frame;
import java.net.*;
import util.*;
public class Rece extends Thread{
	
	public  void run(){
		DatagramSocket ds=null;
		try {
			ds=new DatagramSocket(10001);//�˿ں�
			while(true){
				byte[] buf=new byte[1024];
				//�������ݱ���
				DatagramPacket dp=new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				String data=new String(dp.getData(),0,dp.getLength());//�������ݰ�
				Constant.show.append(data+"\n");
				if (Constant.l.getExtendedState()==1) {//������С���Ĵ���
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
