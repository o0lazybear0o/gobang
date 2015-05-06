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
 *	��������������
 * 
 * 
 * Class: MainChessBoard
 * {
 * 
  	@Override
	public void actionPerformed(ActionEvent e)
	
	//�˵���
	 * ģʽ
	 * ����
	 * 	���ֿ���
	 * 	��Ч����
	 * ������Ϣ
	
	//���ܼ�
	 * ��ʼ
	 * ����
	 * ���
	 * �˳���Ϸ
	
	public ChessBoardPanel ChessBoard = null;
	
	//"����"��Ϣ��
	public JMenu authorInformation = new JMenu("����");
	public JMenuItem IrisChen = new JMenuItem("���");
	public JMenuItem YutingChen = new JMenuItem("������");
	public JMenuItem YuxiHuan = new JMenuItem("������");
	public JMenuItem YulinXie = new JMenuItem("л����");
	
	//��ģʽ���˵���
	public JMenu Mode = new JMenu("ģʽ");
	public JMenuItem TwoPlayers = new JMenuItem("˫��ģʽ");
	public JMenuItem OnePlayer = new JMenuItem("�˻�ģʽ");
	public static boolean TwoPlayersIsOn = true;
	public static boolean AIIsWorking = false;
	
	//�����á��˵���
	public JMenu Setting = new JMenu("����");
	
	public static Player backMusic = null;
	//�Ա������ֵĿ���
	//��������
	public JMenuItem OpenBackMusic = new JMenuItem("��");
	public JMenuItem CloseBackMusic = new JMenuItem("��");
	public JMenu BackMusic = new JMenu("��������");
	public static boolean backIsOn = true;
	public void addBackgroudMusic();
	
	//��Ч����
	public  static boolean isSoundOn = true;
	public JMenuItem CloseSound =  new JMenuItem("��");
	public JMenuItem OpenSound= new JMenuItem("��");
	public JMenu Sound = new JMenu("��Ч");
	
	//��ʼ
    Icon begin = new ImageIcon("gameStart.png");
	public JButton BeginGame =  new JButton(begin);
	public static boolean  isReady = false;
	public static boolean  armyReady = false;
	public static boolean StartGame = false;
	
	//����
	public Icon regret = new ImageIcon("undo.png");
	public JButton Regret =  new JButton(regret);
	public static boolean isRegret = false;
	public static boolean  armyRegret =false;
		
	//�˳���Ϸ
	public Icon exitthegame = new ImageIcon("exit.png");
	public JButton ExitTheGame =  new JButton(exitthegame);
	public  static boolean isSurrender = false;
	public static  boolean  armySurrender =false;

	//���
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

	//��������
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		//����˫����Ϸģʽ
		if (e.getSource() == this.TwoPlayers)
		{
			TwoPlayersIsOn = true;
		}
		
		//�����˻�ģʽ
		if (e.getSource() == this.OnePlayer)
		{
			//AI ģʽ
		}
		
		//�رձ�������
		if (e.getSource() == this.CloseBackMusic)
		{
			if (backIsOn) 
			{
				backMusic.setStop();
				backIsOn = false;
			}
		}
		
		//�򿪱�������
		if (e.getSource() == this.OpenBackMusic)
		{
			if (!backIsOn)
			{
				backMusic.playMusic();
				backIsOn = true;
			}
		}
		
		//��Ч��
		if(e.getSource()==this.OpenSound)
		{
			isSoundOn = true;
		}
		
		//��Ч��
		if(e.getSource()==this.CloseSound)
		{
			isSoundOn = false;		
		}
		
		//��ʼ��Ϸ
		if (e.getSource() == this.BeginGame)
		{
			if (TwoPlayersIsOn)
			{
				int option = JOptionPane.showConfirmDialog( 
		                  null, 
		                  "�Ƿ����¿��֣�", 
		                  "���¿��� ",
		                  JOptionPane.YES_NO_CANCEL_OPTION); 
				if (option == JOptionPane.YES_OPTION)
				{
					this.ChessBoard.restart();
				}
			}
		}
		
		//�˳���Ϸ
		if (e.getSource() == this.ExitTheGame)
		{
			//�˳�
			System.exit(0);
		}
		
		//����
	 	if (e.getSource() == this.Regret)
	 	{
			this.ChessBoard.regret();
	 	}
	 	
		//���
		if (e.getSource() == this.PeaceRequest)
		{
			int option = JOptionPane.showConfirmDialog( 
	                  null, 
	                  "����ȷ���������ˣ�", 
	                  "ƽ�ֽ��� ",
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

	//������
	public ChessBoardPanel ChessBoard = null;
	
	//"����"��Ϣ��
	public JMenu authorInformation = new JMenu("����");
	public JMenuItem IrisChen = new JMenuItem("���");
	public JMenuItem YutingChen = new JMenuItem("������");
	public JMenuItem YuxiHuan = new JMenuItem("������");
	public JMenuItem YulinXie = new JMenuItem("л����");
	
	//��ģʽ���˵���
	public JMenu Mode = new JMenu("ģʽ");
	public JMenuItem TwoPlayers = new JMenuItem("˫��ģʽ");
	public JMenuItem OnePlayer = new JMenuItem("�˻�ģʽ");
	public static boolean TwoPlayersIsOn = true;
	public static boolean AIIsWorking = false;
	
	//�����á��˵���
	public JMenu Setting = new JMenu("����");
	
	public static Player backMusic = null;
	//�Ա������ֵĿ���
	//��������
	public JMenuItem OpenBackMusic = new JMenuItem("��");
	public JMenuItem CloseBackMusic = new JMenuItem("��");
	public JMenu BackMusic = new JMenu("��������");
	public static boolean backIsOn = true;
	public void addBackgroudMusic(){
		backMusic= new Player("background.wav",1);
		backMusic.start();	
	}
	
	//��Ч����
	public  static boolean isSoundOn = true;
	public JMenuItem CloseSound =  new JMenuItem("��");
	public JMenuItem OpenSound= new JMenuItem("��");
	public JMenu Sound = new JMenu("��Ч");
	
	//��ʼ
    Icon begin = new ImageIcon("gameStart.png");
	public JButton BeginGame =  new JButton(begin);
	public static boolean  isReady =false;
	public static boolean  armyReady =false;
	public static boolean StartGame=false;
	
	//����
	public Icon regret = new ImageIcon("undo.png");
	public JButton Regret =  new JButton(regret);
	public static boolean isRegret = false;
	public static boolean  armyRegret =false;
		
	//�˳���Ϸ
	public Icon exitthegame = new ImageIcon("exit.png");
	public JButton ExitTheGame =  new JButton(exitthegame);
	public  static boolean isSurrender = false;
	public static  boolean  armySurrender =false;

	//���
	public Icon peace = new ImageIcon("draw.png");
	public JButton PeaceRequest =  new JButton(peace);
	public static boolean  isPeace = false;
	
	//���������
	/**
	 * 
	 */
	public void addChessBoard()
	{
		this.add(ChessBoard, BorderLayout.CENTER);
		this.ChessBoard.myChessBoard = this;	
	}
	
	//��ӹ��ܼ�
	/**
	 * 
	 */
	public void addFunction()
	{
		JPanel function = new JPanel();
		
		//setBounds ����������ϵ�����λ�úͿ�ȡ��߶�
		function.setBounds(600, 300, 150, 244);
		
		//��function�ӵ����
		this.add(function);
		function.setLayout(new GridLayout(4,1));
		
		//��function�м��뿪ʼ�����䡢��͡��˳��İ�ť
		function.add(this.BeginGame);	
		function.add(this.Regret);
		function.add(this.PeaceRequest);
		function.add(this.ExitTheGame);
		
		function.setOpaque(false);
		//pack();
		
		//�Կ�ʼ�����䡢��͡��˳��İ�ť����
		this.BeginGame.addActionListener(this);
		this.Regret.addActionListener(this);
		this.PeaceRequest.addActionListener(this);
		this.ExitTheGame.addActionListener(this);
		
	}

	//���ò˵���
	/**
	 * 
	 */
	public void setMenuBar()
	{
		
		//�����˵���
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//����˵�һ��
		JMenu menu = new JMenu("�˵�");
		menuBar.add(menu);
		
		//�����˻�/˫�˶�սѡ��
		this.Mode.add(this.TwoPlayers);
		//AI��ʱ��д
		//this.Mode.add(this.OnePlayer);
		
		//������һ���м������ֿ���
		this.Setting.add(this.BackMusic);
		this.BackMusic.add(this.OpenBackMusic);
		this.BackMusic.add(this.CloseBackMusic);
		
		//������һ���м������Ч�Ŀ���
		this.Setting.add(this.Sound);
		this.Sound.add(this.OpenSound);
		this.Sound.add(this.CloseSound);		
		
		//������Ϣ = - = �������еĸ�����TAT
		this.authorInformation.add(this.IrisChen);
		this.authorInformation.add(this.YutingChen);
		this.authorInformation.add(this.YuxiHuan);
		this.authorInformation.add(this.YulinXie);
		
		//�ڲ˵����м��������
		menuBar.add(this.Mode);
		menuBar.add(this.Setting);
		menuBar.add(this.authorInformation);
		
		//�԰������м���
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
		//����ָ�������JFrame���ڶ���
		super("������ TJU");
		
		//�رհ�ť�Ķ���Ϊ�˳�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�趨�ߴ�
		this.setSize(800, 644);
		
		//�������ܰ�ť
		this.addFunction();
		
		//�����˵���
		this.setMenuBar();
		
		this.ChessBoard = new ChessBoardPanel();
		this.setLayout(null);
		this.setResizable(false);
		
		//��ӱ�������
		this.addBackgroudMusic();
		
		//���ô��������ָ�������λ��,�˴��ڽ�������Ļ������
		this.setLocationRelativeTo(null);
		
		//������
		this.addChessBoard();

		//���ô���Ϊ�ɼ���
		this.setVisible(true);
		
	}
	
}