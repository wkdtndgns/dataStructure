package hw10_1;
import java.util.Scanner;

public class UndirectedGraphTest2 
{
	public static void main(String[] args)
	{
		System.out.println("hw10_1 : 전경준");

		UndirectedGraph2 graph;
		Scanner input = new Scanner(System.in);
		int a;
		int b;

		System.out.print("정점 수 입력 :");
		a = input.nextInt();
		graph = new UndirectedGraph2(a);

		while(true)
		{ 
			System.out.println("1:간선삽입 2:인접정점보기 3:깊이우선탐색 4:종료");
			a = input.nextInt();
			if(a==1)
			{
				System.out.print("삽입할 간선을 입력하세요(정점 번호 2개)");
				a = input.nextInt();
				b = input.nextInt();
				
				while(graph.TorF(a, b)) //보너스 과제 True or False
				{
					System.out.println("잘못된 정점입니다.");
					System.out.print("삽입할 간선을 입력하세요(정점 번호 2개)");
					a = input.nextInt();
					b = input.nextInt();
				}
					
				graph.insertEdge(a,b);
			}
			else if(a==2)
			{
				System.out.print("정점 번호를 입력하세요 : ");
				a = input.nextInt();
				graph.printAdjacentVertecies(a);
			}
			else if(a==3)
				graph.depthFirstSearch();
			
			else if(a==4)
				break;
			else;
			System.out.println();
		}

	}
}
