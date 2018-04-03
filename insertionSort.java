package hw11_1;
import java.util.*;

class inSort
{
	static void insertionSort(String str[], int n)
	{
		String temp;
		for(int i=1;i<n;i++)
		{
			temp = str[i];
			int j=i;
			while( j>0 && str[j-1].compareToIgnoreCase(temp)>0)
			{
				str[j]=str[j-1];
				j--;
			}
			str[j]=temp;
		}
		
		for(int i=0;i<n;i++)
			System.out.println(str[i]);
	}
}

public class insertionSort 
{
	public static void main(String[] args) 
	{
		
		System.out.println("hw11_1 : 전경준");
		
		Scanner input = new Scanner(System.in);
		int a;
		System.out.println("단어수 입력 :");
		a=input.nextInt();
		String[] str = new String[a];
		
		input.nextLine(); // 버퍼 비우기
		for(int i=0 ; i<a; i++)
		{
			System.out.println("단어 입력 :");
			str[i] = input.nextLine();
		}
		
		System.out.println(a+"개의 단어 출력 : ");
		for(int i=0 ; i<a; i++)
			System.out.println(str[i]);
		
		System.out.println("사전순 출력 :");
		inSort.insertionSort(str, str.length);
		
		
		
		
	}
}

