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
 *  ����������
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

	//��ͨ���ӵ�ͼƬ
	public static Icon blackchesspiece = new ImageIcon("blackchesspiece.png");
	public static Icon whitechesspiece = new ImageIcon("whitechesspiece.png");
	
	//������ӵ�����ͼƬ
	public static Icon previousblackchesspiece = new ImageIcon("blackMark.png");
	public static Icon previouswhitechesspiece = new ImageIcon("whiteMark.png");
	
	//����������������
    public ChessBoardPanel myBoardPanel  = null;

    //������ɫ
	public ChessColor chessColor = null;
	
	//��������λ��
	public CPoint CurrentCPoint = null;
	
	//constructor
	/**
	 * 
	 * @param chessColor -- ������ɫ
	 * @param CurrentCpoint -- ���ӷ���λ��
	 */
	public ChessPiece(ChessColor chessColor, CPoint CurrentCpoint)
	{
		//�����������
		super(previousblackchesspiece);
		
		//����������ɫ
		this.chessColor = chessColor;
		if (chessColor == ChessColor.WHITE)
		{
			this.setIcon(previouswhitechesspiece);
		}
		
		//�������ӵ�λ��
		this.CurrentCPoint = CurrentCpoint;
		
		//�������ӵı���͸��  
   	 	this.setBackground(null);
   	 	this.setOpaque(false);
   	 	
   	 	//�������ӵ�λ�úͱ߽�
   	 	this.setInitBounds(this.CurrentCPoint);
	}
	
	
	
	//�������ӵ�ͼƬΪ��ͨNormal
	//ʵ������µ����ӱ�Mark��ǵĹ���
	/**
	 * 
	 */
	public void changeIcon()
	{
		//�������ӵ�icon
		if (this.chessColor == ChessColor.WHITE)
		{
			this.setIcon(whitechesspiece);
		}
		else
		{
			this.setIcon(blackchesspiece);
		}
	}
	
	
	
	//�������ӵ�λ��
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