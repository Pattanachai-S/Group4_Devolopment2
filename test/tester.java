import OX_but_MVC.Model;


import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class tester {
	   @Test
	   public void testSetup() {
	      String str= "I am done with Junit setup";
	      assertEquals("I am done with Junit setup",str);
	   }
	   
	   @Test
	   public void test_win() {
		  // test model can play and win
		  System.out.println("test find winner");
	      Model model = new Model();
	      model .change_table_size(2);
	      model.fill_table(0, 0);  // O
	      model.fill_table(0, 1);  // X
	      model.fill_table(1, 0);  // O
	      assertEquals(1,model.get_winner());  // Player 1 win
		  }
} 