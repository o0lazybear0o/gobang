/**
 * 
 * 
 * Project:gobang
 * 
 * 
 * Language: java
 * 
 * 
 * FileName: CPoint.java
 * 
 * 
 * 
 */



package myChessBoard.MainChessBoard;

import java.awt.Point;

import myChess.Enum.ChessColor;

/**
 * 
 * 
 * @author Iris Chen
 * 
 *
 * 
 * Usage: 
 *  ��ͼ�������λ��ͬ�����ϵ�λ�ý�����ϵ
 * 
 * 
 * Class: CPoint{
  
    public int Cx=0;
	public int Cy=0;
	
 	public ChessColor occupiedColor = null;
 		
	public static final double CPWidth = 35;  
	public static final double CPHeight= 35;  
	public static final double  initCx = 37.5;
	public static final double  initCy = 37.5;
	
	public static final double BorderMinCx = 55.0;
	public static final double BorderMaxCx = 545.0;
	public static final double BorderMinCy = 55.0;
	public static final double BorderMaxCy =545.0;
	
	public static final double midum= 399.0;

	public int getCx();
	public void setCx(int cx);
	
	public int getCy() ;
	public void setCy(int cy);
	
	//Constructors
	public CPoint();
	public CPoint(int x ,int y);
	public CPoint(Point MousePoint);
	
	public static CPoint changeToCPoint(Point a);
	public static Point changeToPoint(CPoint a);
	
	public boolean equals(CPoint temp);
	public boolean noChessHere();
	
	public void setChess(ChessColor Color);
	  
  }
 * 
 * 
 */

public class CPoint 
{
	
	//CPoint����ĺ�����
	public int Cx=0;
	//CPoint�����������
	public int Cy=0;
	
	
	//��ǰCPoint�ĸ����������ӵ���ɫ
	//Ĭ�ϵ�ǰ����Ϊ��
	public ChessColor occupiedColor = null;
	
	//ÿһ��Ŀ�ȣ����أ�
	public static final double CPWidth = 35;  
	//ÿһ��ĸ߶ȣ����أ�
	public static final double CPHeight= 35;
	//��ʼ������
	public static final double  initCx = 37.5;    
	//��ʼ������
	public static final double  initCy = 37.5;
	
	
	
	//���̵ı߽���λ��
	//���̵��ϱ߽���
	public static final double BorderMinCx = 55.0;
	//���̵��±߽���
	public static final double BorderMaxCx = 545.0;
	//���̵���߽���
	public static final double BorderMinCy = 55.0;
	//���̵��ұ߽���
	public static final double BorderMaxCy =545.0;
	
	
	public static final double midum= 399.0;
	
	
	//����Cx��ֵ
	/**
	 * 
	 * @return
	 */
	public int getCx() 
	{
		return Cx;
	}
	
	
	//����Cx��ֵ
	/**
	 * 
	 * @param cx
	 */
	public void setCx(int cx) 
	{
		Cx = cx;
	}

	//����Cy��ֵ
	/**
	 * 
	 * 
	 * @return Cy 
	 */
	public int getCy() 
	{
		return Cy;
	}	
	
	//����Cy��ֵ
	/**
	 * 
	 * @param cy
	 */
	public void setCy(int cy) 
	{
		Cy = cy;
	}
	
	
	//constructor:�޲ι��캯��
	/**
	 * 
	 */
	public CPoint()
	{
		
	}
	
	
	//constructor:��������Ϊ��x,y����CPoint
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public CPoint(int x ,int y)
	{
		this.setCx(x);
		this.setCy(y);
	}
	
	//�������㽨�����̵�
	/**
	 * 
	 * @param MousePoint
	 */
	public CPoint(Point MousePoint)      
	{ 	
		CPoint temp;
		temp = new CPoint();
		
		//�������������λ��ת��Ϊ��������
		CPoint.changeToCPoint(MousePoint);
		
		this.Cx = temp.getCx();
		this.Cy = temp.getCy();
	}
	
	
	//��Point����ת��ΪCPoint����
	/**
	 * 
	 * @param a
	 * @return
	 */
	public static CPoint changeToCPoint(Point a)
	{
		CPoint temp;
		temp = new CPoint ();
		
		//�ж�Point�Ƿ񳬳����̱߽�
		if (a.x < BorderMinCx ||
				a.x > BorderMaxCx)
		{
			return null;
		}
		if (a.y < BorderMinCy ||
				a.y > BorderMaxCy)
		{
			return null;
		}
		
		//�õ���a����Ӧ����������
		temp.Cx = (int)(((double)a.x-initCx)/CPWidth);
		temp.Cy = (int)(((double)a.y-initCy)/CPHeight);
		
		return temp; 
	}
	
	
	
	//ת��Ϊ����
	/**
	 * 
	 * @param a
	 * @return
	 */
	public static Point changeToPoint(CPoint a)
	{
		Point temp;
		temp = new Point();
		
		temp.x = (int)((double)a.getCx()*(CPoint.CPWidth)+CPoint.initCx);
		temp.y =(int)((double)a.getCy()*(CPoint.CPHeight)+CPoint.initCy);
		
		return temp;	
	}
	
	
	
	//�ж������Ƿ����
	/**
	 * 
	 * @param temp
	 * @return
	 */
	public boolean equals(CPoint temp)
	{
		return (this.Cx==temp.Cx &&
				this.Cy==temp.Cy);
	}
	
	
	
/*	//ת��Ϊ�����ϵĽڵ�
	public static CPoint changeToNode(Point a)
	{
		return  ChessBoardPanel.nodes[changeToCPoint(a).Cx] [changeToCPoint(a).Cy];
	}
*/
	
	
	
	//�жϵ�ǰλ���Ƿ�������
	/**
	 * 
	 * @return
	 */
	public boolean noChessHere()
	{
		return this.occupiedColor == null;
	}
	
	
	
	//�ڵ�ǰλ�÷�������
	/**
	 * 
	 * @param Color
	 */
	public void setChess(ChessColor Color)
	{
		//this.occupiedColor = new ChessColor();
		this.occupiedColor = Color;
	}
	
	
	
}
