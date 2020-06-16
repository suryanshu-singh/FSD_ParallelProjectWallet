interface Calculate{
		//void add(int firstNum, int secondNum);
		public void work();
	}


public class Exploring /*implements Calculate*/ {
	
	//@Override
//	public void work() {
//		System.out.println("Traditional way");
//	}

	
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		//new Exploring().work();
		Calculate c = ()-> System.out.println("Using lambda");
		c.work();
		Calculate d= new Calculate()
		{
			@Override
			public void work() {
				System.out.println("Using in anonymous");
			}
		};
		d.work();

	}

}
