import static org.junit.Assert.*;
import org.junit.Test;

public class TestBoard
{
	@Test
	public void testCanSelect()
	{
		Board b=new Board(true);
		b.place(new Piece(true,b,3,3,"pawn"),3,3);
		b.place(new Piece(false,b,2,4,"pawn"),2,4);
		b.place(new Piece(false,b,2,6,"pawn"),2,6);
		b.select(3,3);
		assertEquals(b.canEndTurn(),false);
		assertEquals(b.canSelect(1,5),true);//csv
		b.select(1,5);
		assertEquals(b.canEndTurn(),true);//
		
		assertEquals(b.pieceAt(3,3),null);
		assertEquals(b.canSelect(3,7),true);
		b.endTurn();
		assertEquals(b.canSelect(3,7),false);
	}
	@Test
	public void randomTest()
	{
		Board b=new Board(true);
		assertEquals(b.winner(),"No one");
		b.place(new Piece(true,b,3,5,"pawn"),3,5);
		b.place(new Piece(false,b,4,6,"pawn"),4,6);
		b.select(3,5);
		assertEquals(b.canSelect(5,7),true);
		b.select(5,7);
		assertEquals(b.pieceAt(4,6),null);
		assertEquals(b.pieceAt(5,7).hasCaptured(),true);

	}
	public static void main(String... args) 
	{
    	jh61b.junit.textui.runClasses(TestBoard.class);
	}

}