package org.bianqi.seat.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 抢座软件
 * @author BIANQI
 */
public class MainGUI {
	public static void main(String[] args) {
		Frame frame = new MainFrame("齐齐哈尔大学图书馆自习室抢座小助手");
	}
}



class MainFrame extends JFrame{

	JDialog jDialog = null;
	JMenuBar mb = null;
	JMenu m = null;
	JMenu m1 = null;
	JMenuItem closeItem = null;
	JMenuItem aboutItem = null;
	JLabel lbl1 = null;
	JLabel lbl2 = null;
	JLabel lbl3 = null;
	JLabel bll3 = null;
	JTextField txt = null;
	JPasswordField pasw = null;
	JButton btn1 = null;
	ImageIcon img = null;
	JLabel imgLabel = null;
	Container contain = null;
	JComboBox<String> jcb1 = null;
	JComboBox<String> jcb2 = null;
	JComboBox<String> jcb3 = null;
	Frame frame = this;
	public MainFrame(String title) {
		this.init(title);
	}
	
	public void init(String title){
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setLocation(400, 200);
		this.setSize(500, 300);
		this.setTitle(title);
		mb =new JMenuBar();//创建菜单栏
		m = new JMenu("开始");//创建“文件”菜单    
		m1 = new JMenu("关于");
		closeItem = new JMenuItem("退出");//创建“退出"菜单项

		closeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int showConfirmDialog = JOptionPane.showConfirmDialog(frame, "一旦退出,就无法定时抢座!你确定退出?", "退出", JOptionPane.YES_NO_OPTION); 
				if(showConfirmDialog != 1){
					System.exit(0);
				}
			}
		});
		
		aboutItem =new JMenuItem("关于");
		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "      开发者软件141回眸,境界", "关于", JOptionPane.INFORMATION_MESSAGE); 
			}
		});
		
        m.add(closeItem);//将“退出”菜单项添加到“文件”菜单上
        m1.add(aboutItem);
        mb.add(m);//将文件添加到菜单栏上
        mb.add(m1);
        this.setJMenuBar(mb);//将此窗体的菜单栏设置为指定的菜单栏。
        
         //用户名或者密码错误 问题的考虑
        lbl1 = new JLabel("学   号:"); 
        lbl1.setBounds(10, 10, 90, 30);
        lbl2 = new JLabel("密　码:"); 
        lbl2.setBounds(10, 50, 90, 30);
        txt = new JTextField(10); 
        txt.setBounds(60,10, 150, 25);
        pasw = new JPasswordField(10);
        pasw.setBounds(60, 50, 150, 25);
        pasw.setEchoChar('*'); 
        lbl3 = new JLabel("座    位:"); 
        lbl3.setBounds(15,90, 80, 30);
        img = new ImageIcon("images/timg.jpg");  
        //TODO 需要显示座位
        bll3 = new JLabel("座位号");  
        
        String str1[] = {"东区401", "中区101",
        		"中区201", "中区206", "中区211", "西区207",
        		"西区401"};  
        
        String str2[] = {"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神"};
        
        String str3[] = {"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神"};
        
        String str4[] = {"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神"};
        
        String str5[] = {"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神"};
        
        String str6[] = {"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神"};
        
        String str7[] = {"巨坑", "菜鸟", "一般", "大神",
        		"巨"
        		+ "坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神"};
        
        String str8[] = {"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神",
        		"巨坑", "菜鸟", "一般", "大神"};
        
        jcb1 = new JComboBox<>(str1);
        jcb1.setBounds(60,90,130,25);
        jcb2 = new JComboBox<>(str2);
        jcb2.setBounds(250,90,130,25);
        
        imgLabel = new JLabel(img);  
        btn1 = new JButton("定时抢座");
        btn1.setBounds(330, 160, 140, 40);
        
        
        btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(false);
				JOptionPane.showMessageDialog(frame, "定时任务已经为您做好准备13:00开抢,小助手运行中,请勿点击确定", "小助手提示你", JOptionPane.INFORMATION_MESSAGE); 
				int showConfirmDialog = JOptionPane.showConfirmDialog(frame, "如果你选择否,程序将强制运行,定时任务一直处于开启状态,必须启动任务管理器终止程序!如果你选择是程序将退出，定时任务失效!", "小助手提示你", JOptionPane.YES_NO_OPTION); 
				
				if(showConfirmDialog == 1){
					btn1.setText("定时任务正在运行");
					frame.setEnabled(false);
				}else{
					System.exit(0);
				}
				
				System.out.println("I Love Java !!!");
			}
		});
        
        this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));  
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());  
        contain = this.getContentPane();  
        ((JPanel) contain).setOpaque(false);   
        contain.setLayout(null);
        contain.add(lbl1);
        contain.add(txt);  
        contain.add(lbl2);  
        contain.add(pasw);
        contain.add(lbl3);
        contain.add(btn1);
        contain.add(jcb1);
        contain.add(jcb2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//        this.setResizable(false);  
        this.setVisible(true);  
	}
	
}
