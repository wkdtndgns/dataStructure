package hw12_1;

import java.util.Scanner;

public class BinarySearchTest 
{
	public static void main(String[] args) 
	{
		System.out.println("hw12_1 : 전경준");
		System.out.println("저 가르치신다고 고생하셨습니다. 3년 뒤에 뵈요 교수님~~");

		Scanner input = new Scanner(System.in);
		
		System.out.print("학생수 입력  : ");
		int n = input.nextInt();
	
		Students[] arr = new Students[n];

		for (int i=0; i<n; i++) 
		{
			System.out.print("학생"+(i+1)+"의 학번과 성적 입력 :");
			int a, b;
		
			a = input.nextInt();
			b = input.nextInt();
			arr[i] = new Students(a,b);
		}

		for (int i=0; i<n; i++)
			System.out.println(arr[i].toString());

		System.out.println("학생을 학번 순으로 정렬한 결과");
		insertionSort(arr);

		for (int i=0; i<n; i++)
			System.out.println(arr[i].toString());


		for (int i = 0; i < 5; i++)
		{
			System.out.print("학번 입력: ");
			int number = input.nextInt();
			int result = binarySearch(arr, 0, arr.length-1, number);
			
			if (result==-1)
				System.out.println("검색 실패");
			else
				System.out.println("index="+result+" score="+ arr[result].getScore());
		}
		
		System.out.println("종료합니다.");
	}

	static int binarySearch(Students arr[], int low, int high, int key) 
	{
		if (low > high)
			return -1;
		
		else 
		{
			int mid = (low+high) / 2;
			
			if (key == arr[mid].getid())
				return mid;
			else if (key < arr[mid].getid())
				return binarySearch(arr, low, mid - 1, key);
			else
				return binarySearch(arr, mid + 1, high, key);
		}
	}
	
	static void insertionSort(Students[] arr) 
	{
		int i, j;
		Students temp;
		
		for (i = 1; i < arr.length; i++) 
		{
			temp = arr[i];
			for (j = i; (j>0) && temp.getid() < arr[i-1].getid(); j--) 
				arr[j] = arr[j - 1];
			
			arr[j] = temp;
		}
	}
}

class Students 
{
	
	private int id; // 학번
	private int score; // 성적

	public Students(int id, int score)
	{
		this.id = id;
		this.score = score;
	}

	public int getid() 
	{
		return id;
	}

	public int getScore() 
	{
		return score;
	}
	
	public String toString() 
	{
		return "Students [id=" + id + ", score=" + score + "]";
	}
}

