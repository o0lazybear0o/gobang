/**
 * 
 * 
 * Project:gobang
 * 
 * 
 * Language: java
 * 
 * 
 * FileName: MainChessBoard.java
 * 
 * 
 * 
 */

package myChessBoard.MainChessBoard;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.Icon;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;

import javax.swing.JOptionPane;

import javax.swing.JPanel;


/**
 * 
 * 
 * @author Iris Chen
 * 
 *
 * 
 * Usage: 
 *	构建棋盘主界面
 * 
 * 
 * Class: MainChessBoard
 * {
 * 
  	@Override
	public void actionPerformed(ActionEvent e)
	
	//菜单栏
	 * 模式
	 * 设置
	 * 	音乐开关
	 * 	音效开关
	 * 作者信息
	
	//功能键
	 * 开始
	 * 悔棋
	 * 求和
	 * 退出游戏
	
	public ChessBoardPanel ChessBoard = null;
	
	//"作者"信息栏
	public JMenu authorInformation = new JMenu("关于");
	public JMenuItem IrisChen = new JMenuItem("陈璐");
	public JMenuItem YutingChen = new JMenuItem("陈玉婷");
	public JMenuItem YuxiHuan = new JMenuItem("宦羽茜");
	public JMenuItem YulinXie = new JMenuItem("谢玉琳");
	
	//“模式”菜单栏
	public JMenu Mode = new JMenu("模式");
	public JMenuItem TwoPlayers = new JMenuItem("双人模式");
	public JMenuItem OnePlayer = new JMenuItem("人机模式");
	public static boolean TwoPlayersIsOn = true;
	public static boolean AIIsWorking = false;
	
	//“设置”菜单栏
	public JMenu Setting = new JMenu("设置");
	
	public static Player backMusic = null;
	//对背景音乐的控制
	//背景音乐
	public JMenuItem OpenBackMusic = new JMenuItem("开");
	public JMenuItem CloseBackMusic = new JMenuItem("关");
	public JMenu BackMusic = new JMenu("背景音乐");
	public static boolean backIsOn = true;
	public void addBackgroudMusic();
	
	//音效开关
	public  static boolean isSoundOn = true;
	public JMenuItem CloseSound =  new JMenuItem("关");
	public JMenuItem OpenSound= new JMenuItem("开");
	public JMenu Sound = new JMenu("音效");
	
	//开始
    Icon begin = new ImageIcon("gameStart.png");
	public JButton BeginGame =  new JButton(begin);
	public static boolean  isReady = false;
	public static boolean  armyReady = false;
	public static boolean StartGame = false;
	
	//悔棋
	public Icon regret = new ImageIcon("undo.png");
	public JButton Regret =  new JButton(regret);
	public static boolean isRegret = false;
	public static boolean  armyRegret =false;
		
	//退出游戏
	public Icon exitthegame = new ImageIcon("exit.png");
	public JButton ExitTheGame =  new JButton(exitthegame);
	public  static boolean isSurrender = false;
	public static  boolean  armySurrender =false;

	//求和
	public Icon peace = new ImageIcon("draw.png");
	public JButton PeaceRequest =  new JButton(peace);
	public static boolean  isPeace = false;
	
    public void addChessBoard();
    public void addFunction();
    public void setMenuBar();
    public MainChessBoard();
    	  
  }
 * 
 * 
 */

public class MainChessBoard extends JFrame implements ActionListener, Runnable
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3471532205274535922L;
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		while (true) 
		{
			//this.ChessBoard.listenToSelect();
			try 
			{
				Thread.sleep(300);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//动作反馈
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		//启动双人游戏模式
		if (e.getSource() == this.TwoPlayers)
		{
			TwoPlayersIsOn = true;
		}
		
		//启动人机模式
		if (e.getSource() == this.OnePlayer)
		{
			//AI 模式
		}
		
		//关闭背景音乐
		if (e.getSource() == this.CloseBackMusic)
		{
			if (backIsOn) 
			{
				backMusic.setStop();
				backIsOn = false;
			}
		}
		
		//打开背景音乐
		if (e.getSource() == this.OpenBackMusic)
		{
			if (!backIsOn)
			{
				backMusic.playMusic();
				backIsOn = true;
			}
		}
		
		//音效开
		if(e.getSource()==this.OpenSound)
		{
			isSoundOn = true;
		}
		
		//音效开
		if(e.getSource()==this.CloseSound)
		{
			isSoundOn = false;		
		}
		
		//开始游戏
		if (e.getSource() == this.BeginGame)
		{
			if (TwoPlayersIsOn)
			{
				int option = JOptionPane.showConfirmDialog( 
		                  null, 
		                  "是否重新开局？", 
		                  "重新开局 ",
		                  JOptionPane.YES_NO_CANCEL_OPTION); 
				if (option == JOptionPane.YES_OPTION)
				{
					this.ChessBoard.restart();
				}
			}
		}
		
		//退出游戏
		if (e.getSource() == this.ExitTheGame)
		{
			//退出
			System.exit(0);
		}
		
		//悔棋
	 	if (e.getSource() == this.Regret)
	 	{
			this.ChessBoard.regret();
	 	}
	 	
		//求和
		if (e.getSource() == this.PeaceRequest)
		{
			int option = JOptionPane.showConfirmDialog( 
	                  null, 
	                  "你们确定商量好了？", 
	                  "平局结束 ",
	                  JOptionPane.YES_NO_CANCEL_OPTION);
			if (option == JOptionPane.YES_OPTION)
			{
				this.ChessBoard.GameOver();
			}
		}
		
		if (e.getSource() == this.IrisChen)
		{
			JOptionPane.showMessageDialog(null,
					"Iris Chen\n " +
					"ID:1253036\n" +
					"Email:o0lazybear0o@gmail.com");
		}
		
		if (e.getSource() == this.YutingChen)
		{
			JOptionPane.showMessageDialog(null,
					"Yuting Chen\n " +
					"ID:1253022\n" +
					"Email:1419504521@qq.com");
		}
		
		if (e.getSource() == this.YuxiHuan)
		{
			JOptionPane.showMessageDialog(null,
					"Yuxi Huan\n " +
					"ID:1252849\n" +
					"Email:xiaoxiong_guzi@126.com");
		}
		
		if (e.getSource() == this.YulinXie)
		{
			JOptionPane.showMessageDialog(null,
					"Yulin Xie\n " +
					"ID:1253031\n" +
					"Email:904316160@qq.com");
		}
		
	}

	//棋局面板
	public ChessBoardPanel ChessBoard = null;
	
	//"作者"信息栏
	public JMenu authorInformation = new JMenu("关于");
	public JMenuItem IrisChen = new JMenuItem("陈璐");
	public JMenuItem YutingChen = new JMenuItem("陈玉婷");
	public JMenuItem YuxiHuan = new JMenuItem("宦羽茜");
	public JMenuItem YulinXie = new JMenuItem("谢玉琳");
	
	//“模式”菜单栏
	public JMenu Mode = new JMenu("模式");
	public JMenuItem TwoPlayers = new JMenuItem("双人模式");
	public JMenuItem OnePlayer = new JMenuItem("人机模式");
	public static boolean TwoPlayersIsOn = true;
	public static boolean AIIsWorking = false;
	
	//“设置”菜单栏
	public JMenu Setting = new JMenu("设置");
	
	public static Player backMusic = null;
	//对背景音乐的控制
	//背景音乐
	public JMenuItem OpenBackMusic = new JMenuItem("开");
	public JMenuItem CloseBackMusic = new JMenuItem("关");
	public JMenu BackMusic = new JMenu("背景音乐");
	public static boolean backIsOn = true;
	public void addBackgroudMusic(){
		backMusic= new Player("background.wav",1);
		backMusic.start();	
	}
	
	//音效开关
	public  static boolean isSoundOn = true;
	public JMenuItem CloseSound =  new JMenuItem("关");
	public JMenuItem OpenSound= new JMenuItem("开");
	public JMenu Sound = new JMenu("音效");
	
	//开始
    Icon begin = new ImageIcon("gameStart.png");
	public JButton BeginGame =  new JButton(begin);
	public static boolean  isReady =false;
	public static boolean  armyReady =false;
	public static boolean StartGame=false;
	
	//悔棋
	public Icon regret = new ImageIcon("undo.png");
	public JButton Regret =  new JButton(regret);
	public static boolean isRegret = false;
	public static boolean  armyRegret =false;
		
	//退出游戏
	public Icon exitthegame = new ImageIcon("exit.png");
	public JButton ExitTheGame =  new JButton(exitthegame);
	public  static boolean isSurrender = false;
	public static  boolean  armySurrender =false;

	//求和
	public Icon peace = new ImageIcon("draw.png");
	public JButton PeaceRequest =  new JButton(peace);
	public static boolean  isPeace = false;
	
	//添加棋局面板
	/**
	 * 
	 */
	public void addChessBoard()
	{
		this.add(ChessBoard, BorderLayout.CENTER);
		this.ChessBoard.myChessBoard = this;	
	}
	
	//添加功能键
	/**
	 * 
	 */
	public void addFunction()
	{
		JPanel function = new JPanel();
		
		//setBounds 组件在容器上的坐标位置和宽度、高度
		function.setBounds(600, 300, 150, 244);
		
		//把function加到面板
		this.add(function);
		function.setLayout(new GridLayout(4,1));
		
		//在function中加入开始、认输、求和、退出的按钮
		function.add(this.BeginGame);	
		function.add(this.Regret);
		function.add(this.PeaceRequest);
		function.add(this.ExitTheGame);
		
		function.setOpaque(false);
		//pack();
		
		//对开始、认输、求和、退出的按钮监听
		this.BeginGame.addActionListener(this);
		this.Regret.addActionListener(this);
		this.PeaceRequest.addActionListener(this);
		this.ExitTheGame.addActionListener(this);
		
	}

	//设置菜单栏
	/**
	 * 
	 */
	public void setMenuBar()
	{
		
		//创建菜单栏
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//加入菜单一栏
		JMenu menu = new JMenu("菜单");
		menuBar.add(menu);
		
		//加入人机/双人对战选项
		this.Mode.add(this.TwoPlayers);
		//AI暂时待写
		//this.Mode.add(this.OnePlayer);
		
		//在设置一栏中加入音乐控制
		this.Setting.add(this.BackMusic);
		this.BackMusic.add(this.OpenBackMusic);
		this.BackMusic.add(this.CloseBackMusic);
		
		//在设置一栏中加入对音效的控制
		this.Setting.add(this.Sound);
		this.Sound.add(this.OpenSound);
		this.Sound.add(this.CloseSound);		
		
		//作者信息 = - = 我真是闲的各种疼TAT
		this.authorInformation.add(this.IrisChen);
		this.authorInformation.add(this.YutingChen);
		this.authorInformation.add(this.YuxiHuan);
		this.authorInformation.add(this.YulinXie);
		
		//在菜单栏中加入各个栏
		menuBar.add(this.Mode);
		menuBar.add(this.Setting);
		menuBar.add(this.authorInformation);
		
		//对按键进行监听
		this.OpenBackMusic.addActionListener(this);
		this.CloseBackMusic.addActionListener(this);
		this.OpenSound.addActionListener(this);
		this.CloseSound.addActionListener(this);
		this.TwoPlayers.addActionListener(this);
		//this.OnePlayer.addActionListener(this);
		this.IrisChen.addActionListener(this);
		this.YutingChen.addActionListener(this);
		this.YuxiHuan.addActionListener(this);
		this.YulinXie.addActionListener(this);
		
	}
	
	//constructor
	/**
	 * 
	 */
	public MainChessBoard()
	{
		//创建指定标题的JFrame窗口对象
		super("五子棋 TJU");
		
		//关闭按钮的动作为退出窗口
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设定尺寸
		this.setSize(800, 644);
		
		//创建功能按钮
		this.addFunction();
		
		//创建菜单栏
		this.setMenuBar();
		
		this.ChessBoard = new ChessBoardPanel();
		this.setLayout(null);
		this.setResizable(false);
		
		//添加背景音乐
		this.addBackgroudMusic();
		
		//设置窗口相对于指定组件的位置,此窗口将置于屏幕的中央
		this.setLocationRelativeTo(null);
		
		//添加棋局
		this.addChessBoard();

		//设置窗口为可见的
		this.setVisible(true);
		
	}
	
}