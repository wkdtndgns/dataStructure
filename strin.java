package lecture;

public class strin{

	
	public static void main(String args){
		String[] list = new String[] { "one" ,"two" ,"three","four","five","six","seven"};
		
		String temp =" ";
		for(String s:list){
			if(temp.length()>0) temp=temp+ "";
			temp = temp+ "\""+ s + "\"";									
		}
		
		System.out.println(temp);
		
		
		
		StringBuilder builder =new StringBuilder();
		for(String s: list){
			
			if(builder.length()>0)builder.append(", ");
			builder.append('"');
			
			
			
		}
		
		
		System.out.println(builder.toString());
		
	}

}
