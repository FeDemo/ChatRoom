package socketDemo;

import java.net.*;

import util.Constant;

public class Send{
	private DatagramSocket ds=null;
	public Send(){
		try {
			ds=new DatagramSocket();//绑定到本机任意可用端口
		} catch (Exception e) {
			if (ds != null)
				ds.close();
			System.out.println("已结关闭DatagramSocket");
			e.printStackTrace();
		}
	}
	public void run(String date){
		try {
			String line=Constant.nickname+date;
			byte[] buf = line.getBytes();//包装成数组
			DatagramPacket dp = //广播发送
			new DatagramPacket(buf,buf.length,InetAddress.getByName("255.255.255.255"),10001);
			ds.send(dp);//向dp发送数据报
		} catch (Exception e) {
			if (ds != null)
				ds.close();
			System.out.println("已结关闭DatagramSocket");
			e.printStackTrace();
		}
	}
	/**
	 * 关闭资源
	 */
	public  void closeDs() {
		try {
			if (ds != null)
				ds.close();
			System.out.println("已结关闭DatagramSocket");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
