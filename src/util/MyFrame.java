package util;

import java.awt.*;
import java.awt.event.*;



public abstract class MyFrame  extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���ش���
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(0, 729);
		setVisible(true);
		setTitle(Constant.title);//��������
		setAlwaysOnTop(true);//���������ڵ�һλ
		addComp();
		//new PaintThread().start();  //�����ػ��߳�
		//�ڲ���,����رհ�ťʱ��ر����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				windowC();
				System.exit(0);
			}
		});
	}
	/**
	 * �ڹر����ǰ��Ҫ������
	 */
	abstract public void windowC();
	/**
	 * ��Ӵ������
	 */
	abstract public void addComp();
	
	/**
	 * ˫��������˸
	 */
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if(offScreenImage == null)
			offScreenImage = this.createImage(300,Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImage.getGraphics();

		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
	 * @author dell
	 *
	 */
	class PaintThread extends Thread {
		
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(30); //1s = 1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}   
			}
		}
		
	}
}
