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
 *  把图像的像素位置同棋盘上的位置建立联系
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
	
	//CPoint坐标的横坐标
	public int Cx=0;
	//CPoint坐标的纵坐标
	public int Cy=0;
	
	
	//当前CPoint的格子所在棋子的颜色
	//默认当前格子为空
	public ChessColor occupiedColor = null;
	
	//每一格的宽度（像素）
	public static final double CPWidth = 35;  
	//每一格的高度（像素）
	public static final double CPHeight= 35;
	//起始横坐标
	public static final double  initCx = 37.5;    
	//起始纵坐标
	public static final double  initCy = 37.5;
	
	
	
	//棋盘的边界线位置
	//棋盘的上边界线
	public static final double BorderMinCx = 55.0;
	//棋盘的下边界线
	public static final double BorderMaxCx = 545.0;
	//棋盘的左边界线
	public static final double BorderMinCy = 55.0;
	//棋盘的右边界线
	public static final double BorderMaxCy =545.0;
	
	
	public static final double midum= 399.0;
	
	
	//返回Cx的值
	/**
	 * 
	 * @return
	 */
	public int getCx() 
	{
		return Cx;
	}
	
	
	//设置Cx的值
	/**
	 * 
	 * @param cx
	 */
	public void setCx(int cx) 
	{
		Cx = cx;
	}

	//返回Cy的值
	/**
	 * 
	 * 
	 * @return Cy 
	 */
	public int getCy() 
	{
		return Cy;
	}	
	
	//设置Cy的值
	/**
	 * 
	 * @param cy
	 */
	public void setCy(int cy) 
	{
		Cy = cy;
	}
	
	
	//constructor:无参构造函数
	/**
	 * 
	 */
	public CPoint()
	{
		
	}
	
	
	//constructor:构造坐标为（x,y）的CPoint
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
	
	//根据鼠标点建立棋盘点
	/**
	 * 
	 * @param MousePoint
	 */
	public CPoint(Point MousePoint)      
	{ 	
		CPoint temp;
		temp = new CPoint();
		
		//把鼠标点击的像素位置转换为棋盘坐标
		CPoint.changeToCPoint(MousePoint);
		
		this.Cx = temp.getCx();
		this.Cy = temp.getCy();
	}
	
	
	//把Point类型转换为CPoint类型
	/**
	 * 
	 * @param a
	 * @return
	 */
	public static CPoint changeToCPoint(Point a)
	{
		CPoint temp;
		temp = new CPoint ();
		
		//判断Point是否超出棋盘边界
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
		
		//得到点a所对应的棋盘坐标
		temp.Cx = (int)(((double)a.x-initCx)/CPWidth);
		temp.Cy = (int)(((double)a.y-initCy)/CPHeight);
		
		return temp; 
	}
	
	
	
	//转换为坐标
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
	
	
	
	//判断坐标是否相等
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
	
	
	
/*	//转换为棋盘上的节点
	public static CPoint changeToNode(Point a)
	{
		return  ChessBoardPanel.nodes[changeToCPoint(a).Cx] [changeToCPoint(a).Cy];
	}
*/
	
	
	
	//判断当前位置是否有棋子
	/**
	 * 
	 * @return
	 */
	public boolean noChessHere()
	{
		return this.occupiedColor == null;
	}
	
	
	
	//在当前位置放置棋子
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
