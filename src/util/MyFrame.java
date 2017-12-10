package util;

import java.awt.*;
import java.awt.event.*;



public abstract class MyFrame  extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 加载窗口
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(0, 729);
		setVisible(true);
		setTitle(Constant.title);//窗体名字
		setAlwaysOnTop(true);//将窗口置于第一位
		addComp();
		//new PaintThread().start();  //启动重画线程
		//内部类,点击关闭按钮时会关闭软件
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				windowC();
				System.exit(0);
			}
		});
	}
	/**
	 * 在关闭软件前需要做的事
	 */
	abstract public void windowC();
	/**
	 * 添加窗口组件
	 */
	abstract public void addComp();
	
	/**
	 * 双缓冲消闪烁
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
	 * 定义一个重画窗口的线程类，是一个内部类
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
