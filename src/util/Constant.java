package util;

import java.awt.*;

import socketDemo.ChatRoom;
import socketDemo.Send;

/**
 * 游戏项目中用到的常量
 * @author dell
 *
 */
public class Constant {
	public static final int GAME_WIDTH = 232;//窗口宽度
	public static final int GAME_HEIGHT = 318;//窗口高度
	public static final String title="Chat2.3";//标题名字
	public static String nickname="Fe:\n";//默认昵称
	public static final Send send=new Send();//创建输入端
	public static TextArea show=new TextArea("", 14, 28, TextArea.SCROLLBARS_VERTICAL_ONLY);
	public static ChatRoom l=null;
}
