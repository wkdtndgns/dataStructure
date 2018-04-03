package skhu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Comparator;

public class Example1 {
    
    static Random random = new Random();
    
    static String makeRandomString() {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i < 4; ++i) {
            int n = random.nextInt(26) + (int)'a';
            builder.append((char)n);
        }
        return builder.toString();
    }

    static String[] makeStringArray(int count) {
        String[] a = new String[count];
        for (int i = 0; i < count; ++i)
            a[i] = makeRandomString();
        return a;
    }
    
    static void sortAscending(String[] a) {
        // 오름차순으로 정렬
    	Arrays.sort(a);
    	
    }

    static void sortDescending(String[] a) {
        // 내림차순으로 정렬        
    	Comparator<String> stringComparator = new StringComparator();
    	Arrays.sort(a,stringComparator);
    	
    }
    
    

    public static void main(String[] args) {
        String[] a = makeStringArray(20);
        System.out.println(Arrays.toString(a));
        
        sortAscending(a);
        System.out.println(Arrays.toString(a));

        sortDescending(a);
        System.out.println(Arrays.toString(a));
    }

}


class StringComparator implements Comparator<String>{

	private Comparator compare;
	
	public StringComparator(){
		this.compare = compare;
		
	}

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		
		
		if(s1==s2) return 0;
		if(s1==null)return-1;
		if(s2==null)return 1;		
		
		return s2.compareTo(s1)-s1.compareTo(s2);
	
	}
	
	
	
	
	
}

