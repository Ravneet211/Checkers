public class Piece
{	private boolean fire,king,hasCaptured;
	private Board board;
	private int cx,cy,cxp=-1,cyp=-1;
	private String typeOfPiece;
	public Piece(boolean isFire, Board b, int x, int y, String type)
	{
		fire=isFire;
		board=b;
		cx=x;
		cy=y;
		typeOfPiece=type;//hsjsg
		king=false;
		hasCaptured=false;
	}
	public boolean isFire()
	{
		return fire;
	}
	public int side()
	{
		if(fire)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	public boolean isKing()
	{
		if ((fire && cy==7)||(!fire && cy==0))
		{
			king=true;
		}

		return king;
	}
	public boolean isBomb()
	{
		if (typeOfPiece.equals("bomb"))
		{
			return true;
		}
		return false;
	}
	public boolean isShield()
	{
		if (typeOfPiece.equals("shield"))
		{
			return true;
		}
		return false;	
	}
	public void move(int x, int y)
	{
		cxp=cx;
		cyp=cy;
		board.remove(cx,cy);
		if(Math.abs(x-cx)==2)
		{
			board.remove((x+cx)/2,(y+cy)/2);
			if(typeOfPiece.equals("bomb"))
			{	
				if(board.pieceAt(x+1,y+1)!=null && !board.pieceAt(x+1,y+1).isShield())
				{
					board.remove(x+1,y+1);
				}
				if(board.pieceAt(x+1,y-1)!=null &&!board.pieceAt(x+1,y-1).isShield())
				{
					board.remove(x+1,y-1);
				}
				if(board.pieceAt(x-1,y+1)!=null && !board.pieceAt(x-1,y+1).isShield())
				{
					board.remove(x-1,y+1);
				}
				if(board.pieceAt(x-1,y-1)!=null && !board.pieceAt(x-1,y-1).isShield())
				{
					board.remove(x-1,y-1);
				}
				return;
			}
			else
			{
				board.place(this,x,y);
			}
		}
			
		if((fire&&y==7)||(!fire&&y==0))
		{
			king=true;
		}
		cx=x;
		cy=y;
		board.place(this,x,y);
	}
	public boolean hasCaptured()
	{	if (cxp!=-1)
		{
			if (Math.abs(cx-cxp)==2 && Math.abs(cy-cyp)==2)
			{
				hasCaptured=true;
			}
		}	
		return hasCaptured;
	}
	public void doneCapturing()
	{	
		cxp=-1;
		cyp=-1;
		hasCaptured=false;
	}
}