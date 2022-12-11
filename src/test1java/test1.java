package test1java;

public class test1 {
	  public static void main(String[] args) {
		    //System.out.println("Hello World");
		    //test_loop();
		    test_for();
		  }
	  
	  public static void test_loop() {
		  System.out.println("test loop");
		  int i = 0;
		  while (i < 5) {
			System.out.print("i = ");
		    System.out.println(i);
		    i++;
		  }
	  }
	  
	  public static void test_for() {
		  System.out.println("test For loop");
		  for (int i = 0; i < 5; i++) {
			  System.out.print("i = ");
			  System.out.println(i);
			}
	  }
}
