package util;

import java.awt.*;

import socketDemo.ChatRoom;
import socketDemo.Send;

/**
 * ��Ϸ��Ŀ���õ��ĳ���
 * @author dell
 *
 */
public class Constant {
	public static final int GAME_WIDTH = 232;//���ڿ��
	public static final int GAME_HEIGHT = 318;//���ڸ߶�
	public static final String title="Chat2.3";//��������
	public static String nickname="Fe:\n";//Ĭ���ǳ�
	public static final Send send=new Send();//���������
	public static TextArea show=new TextArea("", 14, 28, TextArea.SCROLLBARS_VERTICAL_ONLY);
	public static ChatRoom l=null;
}
