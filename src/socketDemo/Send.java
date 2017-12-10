package socketDemo;

import java.net.*;

import util.Constant;

public class Send{
	private DatagramSocket ds=null;
	public Send(){
		try {
			ds=new DatagramSocket();//�󶨵�����������ö˿�
		} catch (Exception e) {
			if (ds != null)
				ds.close();
			System.out.println("�ѽ�ر�DatagramSocket");
			e.printStackTrace();
		}
	}
	public void run(String date){
		try {
			String line=Constant.nickname+date;
			byte[] buf = line.getBytes();//��װ������
			DatagramPacket dp = //�㲥����
			new DatagramPacket(buf,buf.length,InetAddress.getByName("255.255.255.255"),10001);
			ds.send(dp);//��dp�������ݱ�
		} catch (Exception e) {
			if (ds != null)
				ds.close();
			System.out.println("�ѽ�ر�DatagramSocket");
			e.printStackTrace();
		}
	}
	/**
	 * �ر���Դ
	 */
	public  void closeDs() {
		try {
			if (ds != null)
				ds.close();
			System.out.println("�ѽ�ر�DatagramSocket");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
