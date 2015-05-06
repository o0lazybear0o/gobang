/**
 * 
 * 
 * Project:gobang
 * 
 * 
 * Language: java
 * 
 * 
 * FileName: ChessBoardPanel.java
 * 
 * 
 * 
 */

package myChessBoard.MainChessBoard;

import java.awt.Graphics;

import java.awt.Image;

import java.awt.Toolkit;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import myChess.ChessPiece.ChessPiece;

import myChess.Enum.ChessColor;


/**
 * 
 * 
 * @author Iris Chen
 * 
 *
 * 
 * Usage: 
 *	�������
 * 
 * 
 * Class: ChessBoardPanel
 * {
 * 
 * 
    	  
  }
 * 
 * 
 */


@SuppressWarnings("serial")
public class ChessBoardPanel extends JPanel implements MouseListener
{
	
	//���̱߳�
	public static final int EDGE = 15;
	
	//��ǰ��������ɫ
	public ChessColor CurrentColor = ChessColor.BLACK;
	
	//����ǰ���һ��
	public CPoint previousCPoint = null;
	public ChessPiece previousChessPiece = null;
	
	//����ͼƬ
	final Image img = 
			Toolkit.getDefaultToolkit().createImage("chessboard.jpg");
	
	//����ÿ�������ϵĵ㴴��CPoint
	public CPoint nodes[][] = new CPoint[EDGE][EDGE];
	
	public int chessPieceNumber = 0;
	
	//������Ч
	public Player Sound = new Player("sound.wav",0);
	public MainChessBoard myChessBoard = null;	
	
	//��Ϸ�Ƿ����
	public boolean isGameOver = false;
	
	//��������
	/**
	 * 
	 */
	protected void paintChildren(Graphics g) 
	{
		g.drawImage(img, 0, 0, this);
		this.myChessBoard.repaint();
		super.paintChildren(g);
	}
	
	//constructor
	/**
	 * 
	 */
	public ChessBoardPanel() 
	{	
		super();
		
		//λ�úͱ߽�
		this.setBounds(0, 0, 800, 600);
		
		//���������
		this.addMouseListener(this);
		
		//��Ч
		this.Sound.start();
        this.setLayout(null);
        
        //����CPoint
        for (int i = 0; i < ChessBoardPanel.EDGE; ++i)
        	for (int j = 0; j < ChessBoardPanel.EDGE; ++j)
        		nodes[i][j] = new CPoint(i, j);
        
	}
	
	//��ʼ������
	/**
	 * 
	 */
	public void setCPoint()
	{
		for(int i=0; i < EDGE; ++i)
		{
			for(int j=0;j<EDGE; ++j)
			{
				nodes[i][j] = new CPoint(i,j);
			}
		}
	}

	
	//�ж��Ƿ�ʤ��
	/**
	 * 
	 * @return
	 */
	public boolean checkWin()
	{
		//���ң����£��ԽǷ�����н�
		int[] dx = {1, 0, 1, -1};
		int[] dy = {0, 1, 1, 1};
		
		for (int x = 0; x < 15; ++x)
			for (int y = 0; y < 15; ++y)
				for (int k = 0; k < 4; k++)
				{
					//�ж��Ƿ�������
					if (nodes[x][y].noChessHere())
					{
						continue;
					}
					
					int tt = 0;
					
					for (int tx = x, ty = y; tt < 5; )
					{
						//�ж��Ƿ�Խ��
						if (tx >= EDGE || ty >= EDGE ||
								tx < 0 || ty < 0)
						{
							break;
						}
						
						//�жϴ˴��Ƿ�������
						if (nodes[tx][ty].noChessHere()) 
						{
							break;
						}
						
						//�ж�������ɫ�����ͬ
						if (nodes[tx][ty].occupiedColor 
								!= nodes[x][y].occupiedColor) 
						{
							break;
						}
						
						tx += dx[k]; 
						ty += dy[k]; 
						++tt;
						
					}	
					
					if (tt == 5) 
					{
						return true;
					}
				}		
		return false;
	}

	//ƽ����Ϸ����
	/**
	 * 
	 */
	public void GameOver()
	{
		JOptionPane.showMessageDialog(null, "ƽ��");
		this.isGameOver = true;
	}
	
	
	//��ʤ������Ϸ����
	/**
	 * 
	 * @param winner
	 */
	public void GameOver(ChessColor winner)
	{
		//winner wins!
		if (winner == ChessColor.BLACK)
		{
			JOptionPane.showMessageDialog(null, "����ʤ����");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "����ʤ����");
		}
		
		//��Ϸ����
		this.isGameOver = true;
	}
	
	
	//���ĵ�ǰ��ɫ
	//�ı䵱ǰѡ��
	/**
	 * 
	 */
	public void swapCurrentColor()
	{
		if (this.CurrentColor == ChessColor.BLACK)
		{
			this.CurrentColor = ChessColor.WHITE;
		}
		else
		{
			this.CurrentColor = ChessColor.BLACK;
		}
	}
	
	
	//����
	//��targetλ�÷���һ������
	/**
	 * 
	 * @param target
	 */
	public void setChessPiece(CPoint target)
	{
		ChessPiece newChessPiece;
		newChessPiece = new ChessPiece(this.CurrentColor, target);
		
		//��targetλ������
		this.nodes[target.Cx][target.Cy].setChess(this.CurrentColor);
		++chessPieceNumber;
		this.add(newChessPiece);
		this.Sound.playSound();
		
		//ǰһö���Ӹ���Ϊ��ͨͼ��
		if (this.previousChessPiece != null)
		{
			this.previousChessPiece.changeIcon();
		}
		
		this.repaint();
		
		//������Ӹ���Ϊ��ǰ����
		this.previousCPoint = target;
		this.previousChessPiece = newChessPiece;
		this.myChessBoard.repaint();
		
		//�ж��Ƿ���Ϸ�ѳ���ʤ��
		if (this.checkWin())
		{
			this.GameOver(this.CurrentColor);
		}
		else
		{
			this.swapCurrentColor();
		}
		
		if (chessPieceNumber == 225)
		{
			GameOver();
		}
	}
	
	//����
	/**
	 * 
	 */
	public void regret()
	{
		//������Ӳ�����ʱ���ɻ���
		if (this.previousCPoint == null)
		{
			JOptionPane.showMessageDialog(null, "���ܷ���~");
			return;
		}
		//������ǰ����˫����ɫ
		this.swapCurrentColor();
		
		this.nodes[this.previousCPoint.Cx][this.previousCPoint.Cy].occupiedColor = null;
		this.remove(this.previousChessPiece);
		--chessPieceNumber;
		repaint();
		
		this.previousCPoint = null;
		this.previousChessPiece = null;
		
	}
	
	@Override
	//���������
	public void mouseClicked(MouseEvent e) {
		//��ȡ�����λ��
		CPoint targetCPoint = CPoint.changeToCPoint(e.getPoint());
		
		if (isGameOver || targetCPoint == null ||
				! this.nodes[targetCPoint.Cx][targetCPoint.Cy].noChessHere())
		{
			return;
		}
		
		this.setChessPiece(targetCPoint);
	}
	
	//������Ϸ
	/**
	 * 
	 */
	public void restart()
	{
		for (int i = 0; i < ChessBoardPanel.EDGE; ++i)
		{
			for (int j = 0; j < ChessBoardPanel.EDGE; ++j)
			{
				nodes[i][j].occupiedColor = null;
			}
		}
		
		chessPieceNumber = 0;
		this.previousChessPiece = null;
		this.previousCPoint = null;
		this.isGameOver = false;
		this.CurrentColor = ChessColor.BLACK;
		this.removeAll();
		
		repaint();
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
}
