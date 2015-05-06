/**
 * 
 * 
 * Project:gobang
 * 
 * 
 * Language: java
 * 
 * 
 * FileName: ChessPiece.java
 * 
 * 
 * 
 */

package myChess.ChessPiece;

import java.awt.Point;

import javax.swing.Icon;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import myChess.Enum.ChessColor;

import myChessBoard.MainChessBoard.CPoint;

import myChessBoard.MainChessBoard.ChessBoardPanel;

/**
 * 
 * 
 * @author Iris Chen
 * 
 *
 * 
 * Usage: 
 *  构建棋子类
 * 
 * 
 * Class: ChessPiece
 * {
 * 
  	public static Icon blackchesspiece;
	public static Icon whitechesspiece;
	public static Icon previousblackchesspiece;
	public static Icon previouswhitechesspiece;
	
    public ChessBoardPanel myBoardPanel  = null;
    
	public ChessColor chessColor = null;
	
	public CPoint CurrentCPoint=null;
	
	//constructor
	public ChessPiece(ChessColor chessColor, CPoint CurrentCpoint);
	
	public void changeIcon();
	
	public void setInitBounds(CPoint Cpoint);
    	  
  }
 * 
 * 
 */



@SuppressWarnings("serial")
public class ChessPiece extends JLabel 
{

	//普通棋子的图片
	public static Icon blackchesspiece = new ImageIcon("blackchesspiece.png");
	public static Icon whitechesspiece = new ImageIcon("whitechesspiece.png");
	
	//最后落子的棋子图片
	public static Icon previousblackchesspiece = new ImageIcon("blackMark.png");
	public static Icon previouswhitechesspiece = new ImageIcon("whiteMark.png");
	
	//棋子所关联的棋盘
    public ChessBoardPanel myBoardPanel  = null;

    //棋子颜色
	public ChessColor chessColor = null;
	
	//棋子所在位置
	public CPoint CurrentCPoint = null;
	
	//constructor
	/**
	 * 
	 * @param chessColor -- 棋子颜色
	 * @param CurrentCpoint -- 棋子放置位置
	 */
	public ChessPiece(ChessColor chessColor, CPoint CurrentCpoint)
	{
		//创建这个棋子
		super(previousblackchesspiece);
		
		//设置棋子颜色
		this.chessColor = chessColor;
		if (chessColor == ChessColor.WHITE)
		{
			this.setIcon(previouswhitechesspiece);
		}
		
		//设置棋子的位置
		this.CurrentCPoint = CurrentCpoint;
		
		//设置棋子的背景透明  
   	 	this.setBackground(null);
   	 	this.setOpaque(false);
   	 	
   	 	//设置棋子的位置和边界
   	 	this.setInitBounds(this.CurrentCPoint);
	}
	
	
	
	//更改棋子的图片为普通Normal
	//实现最后下的棋子被Mark标记的功能
	/**
	 * 
	 */
	public void changeIcon()
	{
		//更改棋子的icon
		if (this.chessColor == ChessColor.WHITE)
		{
			this.setIcon(whitechesspiece);
		}
		else
		{
			this.setIcon(blackchesspiece);
		}
	}
	
	
	
	//设置棋子的位置
	/**
	 * 
	 * @param Cpoint
	 */
	 public void setInitBounds(CPoint Cpoint)
	 {
    	 this.CurrentCPoint = Cpoint;
    	 Point temp = CPoint.changeToPoint(Cpoint);
    	 this.setBounds(temp.x,temp.y,(int)CPoint.CPWidth,(int)CPoint.CPHeight);
     }	
	 
	 
	 
}