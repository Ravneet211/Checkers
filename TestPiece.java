import static org.junit.Assert.*;
import org.junit.Test;

public class TestPiece
{
	
	@Test
	public void testIsFire()
	{	
		Board b = new Board(false);
		assertEquals(true,b.pieceAt(0,0).isFire());
		assertEquals(false,b.pieceAt(1,7).isFire());
	}
	@Test
	public void testIsKing()
	{	
		Board b=new Board(true);
		b.place(new Piece(true,b,6,6,"pawn"),6,6);//csvklo
		b.pieceAt(6,6).move(7,7);
		b.pieceAt(7,7).move(6,6);
		assertEquals(b.pieceAt(7,7).isKing(),true);
	}
	@Test
	public void testIsBomb()
	{
		Board b=new Board(false);
		assertEquals(true,new Piece(true,b,2,2,"bomb").isBomb());
		assertEquals(false,new Piece(true,b,2,2,"pawn").isBomb());

	}
	@Test
	public void testIsShield()
	{
		Board b=new Board(false);
		assertEquals(false,new Piece(true,b,2,2,"bomb").isShield());
		assertEquals(true,new Piece(true,b,2,2,"shield").isShield());

	}
	@Test
	public void testMove()
	{
		Board b=new Board(true);
		b.place(new Piece(true,b,3,3,"bomb"),3,3);
		b.place(new Piece(false,b,2,4,"shield"),2,4);
		b.place(new Piece(false,b,2,6,"shield"),2,6);
		b.place(new Piece(false,b,0,6,"pawn"),0,6);
		b.place(new Piece(true,b,0,4,"bomb"),0,4);
		b.pieceAt(3,3).move(1,5);
		assertEquals(null,b.pieceAt(3,3));
		assertEquals(null,b.pieceAt(0,6));
		assertEquals(null,b.pieceAt(0,4));
		assertEquals(true,b.pieceAt(2,6).isShield());
	}
	@Test
	public void testHasAndDoneCaptured()
	{
		Board b=new Board(true);
		b.place(new Piece(true,b,3,3,"pawn"),3,3);
		b.place(new Piece(false,b,2,4,"shield"),2,4);
		b.pieceAt(3,3).move(1,5);
		assertEquals(b.pieceAt(1,5).hasCaptured(),true);
		b.pieceAt(1,5).doneCapturing();
		assertEquals(b.pieceAt(1,5).hasCaptured(),false);
	}
	
	public static void main(String... args) {
        jh61b.junit.textui.runClasses(TestPiece.class);
    }
}