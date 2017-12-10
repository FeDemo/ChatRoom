package socketDemo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.Scanner;

import util.*;
/** 
_______________#########_______________________ 
______________############_____________________ 
______________#############____________________ 
_____________##__###########___________________ 
____________###__######_#####__________________ 
____________###_#######___####_________________ 
___________###__##########_####________________ 
__________####__###########_####_______________ 
________#####___###########__#####_____________ 
_______######___###_########___#####___________ 
_______#####___###___########___######_________ 
______######___###__###########___######_______ 
_____######___####_##############__######______ 
____#######__#####################_#######_____ 
____#######__##############################____ 
___#######__######_#################_#######___ 
___#######__######_######_#########___######___ 
___#######____##__######___######_____######___ 
___#######________######____#####_____#####____ 
____######________#####_____#####_____####_____ 
_____#####________####______#####_____###______ 
______#####______;###________###______#________ 
________##_______####________####______________ 
* @author Fe
* @version 2.3
*/  
public class ChatRoom extends MyFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ChatRoom(){}
	public static void main(String[] args) {
		if (args.length!=0) {//�����û��ǳ�
			args[0].length();//���Ȳ��ܳ���15
			if (args[0].length()>15) {
				args[0]=args[0].substring(0,15);
			}
			Constant.nickname=args[0]+":\n";
		}
		Constant.l=new ChatRoom();
		Constant.l.launchFrame();
		new Rece().start();
	}
//	private Image img=GameUtil.getImage("image/p445x550.png");
	/**
	 * �ڴ����л�������(ͼƬ,ͼ��)
	 */
//	public void paint(Graphics g){
//		g.drawImage(img, 270,30,null);
//	}
	/**
	 * ��Ӵ������
	 */
	public void addComp(){
		final TextArea input=new TextArea("",2,25, TextArea.SCROLLBARS_VERTICAL_ONLY);
		add(Constant.show);
		add(input);
		BorderLayout border=new BorderLayout();
		border.setVgap(0);

		setLayout(border);//�ֲ�ʽ����
		border.addLayoutComponent(Constant.show,BorderLayout.NORTH);
		border.addLayoutComponent(input,BorderLayout.SOUTH);

		KeyListener enterKey=new KeyListener() {//�����س��¼�
			public void keyTyped(KeyEvent e) {}//����ĳ����ʱ
			public void keyReleased(KeyEvent e) {}//����ĳ���ַ�ʱ
			public void keyPressed(KeyEvent e) {//�ͷ�ĳ����ʱ
				if (e.getKeyChar()=='\n') {//����س�
					StringBuffer sb=new StringBuffer(input.getText());
					for (;;) {
						int index=0;
						index=sb.indexOf("\n", 0);//���з�
						if (index==-1) {break;}
						sb.deleteCharAt(index);
					}
					Constant.send.run(sb.toString()+"\n");//��������ַ������͸����Ͷ˷���
					input.setText("");//������봰��
				}
			}
		};
		input.addKeyListener(enterKey);//��ӻس��¼�
	}
	
	public void windowC(){//�رմ���ʱ�ͷ���Դ
		Constant.send.closeDs();
	}
	
}





















