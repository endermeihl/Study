package Demo;

public class Single{
	private static volatile Single single;

	private Single(){
		//Todo
	}

	public static Single getInstace(){
		if(single==null){
			synchronized(Single.class){
				if(single==null){
					single=new Single();
				}
			}
		}
		return single;
	}
}