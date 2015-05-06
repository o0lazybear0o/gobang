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
 *	创建棋局
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
	
	//棋盘边长
	public static final int EDGE = 15;
	
	//当前的棋子颜色
	public ChessColor CurrentColor = ChessColor.BLACK;
	
	//悔棋前最后一步
	public CPoint previousCPoint = null;
	public ChessPiece previousChessPiece = null;
	
	//棋盘图片
	final Image img = 
			Toolkit.getDefaultToolkit().createImage("chessboard.jpg");
	
	//对于每个棋盘上的点创建CPoint
	public CPoint nodes[][] = new CPoint[EDGE][EDGE];
	
	public int chessPieceNumber = 0;
	
	//落子音效
	public Player Sound = new Player("sound.wav",0);
	public MainChessBoard myChessBoard = null;	
	
	//游戏是否结束
	public boolean isGameOver = false;
	
	//绘制棋盘
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
		
		//位置和边界
		this.setBounds(0, 0, 800, 600);
		
		//添加鼠标监听
		this.addMouseListener(this);
		
		//音效
		this.Sound.start();
        this.setLayout(null);
        
        //创建CPoint
        for (int i = 0; i < ChessBoardPanel.EDGE; ++i)
        	for (int j = 0; j < ChessBoardPanel.EDGE; ++j)
        		nodes[i][j] = new CPoint(i, j);
        
	}
	
	//初始化坐标
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

	
	//判断是否胜利
	/**
	 * 
	 * @return
	 */
	public boolean checkWin()
	{
		//向右，向下，对角方向的行进
		int[] dx = {1, 0, 1, -1};
		int[] dy = {0, 1, 1, 1};
		
		for (int x = 0; x < 15; ++x)
			for (int y = 0; y < 15; ++y)
				for (int k = 0; k < 4; k++)
				{
					//判断是否有棋子
					if (nodes[x][y].noChessHere())
					{
						continue;
					}
					
					int tt = 0;
					
					for (int tx = x, ty = y; tt < 5; )
					{
						//判断是否越界
						if (tx >= EDGE || ty >= EDGE ||
								tx < 0 || ty < 0)
						{
							break;
						}
						
						//判断此处是否有棋子
						if (nodes[tx][ty].noChessHere()) 
						{
							break;
						}
						
						//判断棋子颜色想否相同
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

	//平局游戏结束
	/**
	 * 
	 */
	public void GameOver()
	{
		JOptionPane.showMessageDialog(null, "平局");
		this.isGameOver = true;
	}
	
	
	//有胜负的游戏结束
	/**
	 * 
	 * @param winner
	 */
	public void GameOver(ChessColor winner)
	{
		//winner wins!
		if (winner == ChessColor.BLACK)
		{
			JOptionPane.showMessageDialog(null, "黑棋胜利！");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "白棋胜利！");
		}
		
		//游戏结束
		this.isGameOver = true;
	}
	
	
	//更改当前颜色
	//改变当前选手
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
	
	
	//落子
	//在target位置放置一颗棋子
	/**
	 * 
	 * @param target
	 */
	public void setChessPiece(CPoint target)
	{
		ChessPiece newChessPiece;
		newChessPiece = new ChessPiece(this.CurrentColor, target);
		
		//在target位置落子
		this.nodes[target.Cx][target.Cy].setChess(this.CurrentColor);
		++chessPieceNumber;
		this.add(newChessPiece);
		this.Sound.playSound();
		
		//前一枚棋子更换为普通图标
		if (this.previousChessPiece != null)
		{
			this.previousChessPiece.changeIcon();
		}
		
		this.repaint();
		
		//最后落子更新为当前棋子
		this.previousCPoint = target;
		this.previousChessPiece = newChessPiece;
		this.myChessBoard.repaint();
		
		//判断是否游戏已出现胜负
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
	
	//悔棋
	/**
	 * 
	 */
	public void regret()
	{
		//最后落子不存在时不可悔棋
		if (this.previousCPoint == null)
		{
			JOptionPane.showMessageDialog(null, "不能反悔~");
			return;
		}
		//交换当前下棋双方颜色
		this.swapCurrentColor();
		
		this.nodes[this.previousCPoint.Cx][this.previousCPoint.Cy].occupiedColor = null;
		this.remove(this.previousChessPiece);
		--chessPieceNumber;
		repaint();
		
		this.previousCPoint = null;
		this.previousChessPiece = null;
		
	}
	
	@Override
	//鼠标点击动作
	public void mouseClicked(MouseEvent e) {
		//获取鼠标点击位置
		CPoint targetCPoint = CPoint.changeToCPoint(e.getPoint());
		
		if (isGameOver || targetCPoint == null ||
				! this.nodes[targetCPoint.Cx][targetCPoint.Cy].noChessHere())
		{
			return;
		}
		
		this.setChessPiece(targetCPoint);
	}
	
	//重新游戏
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
