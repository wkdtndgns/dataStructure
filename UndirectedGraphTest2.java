package hw10_1;
import java.util.Scanner;

public class UndirectedGraphTest2 
{
	public static void main(String[] args)
	{
		System.out.println("hw10_1 : ������");

		UndirectedGraph2 graph;
		Scanner input = new Scanner(System.in);
		int a;
		int b;

		System.out.print("���� �� �Է� :");
		a = input.nextInt();
		graph = new UndirectedGraph2(a);

		while(true)
		{ 
			System.out.println("1:�������� 2:������������ 3:���̿켱Ž�� 4:����");
			a = input.nextInt();
			if(a==1)
			{
				System.out.print("������ ������ �Է��ϼ���(���� ��ȣ 2��)");
				a = input.nextInt();
				b = input.nextInt();
				
				while(graph.TorF(a, b)) //���ʽ� ���� True or False
				{
					System.out.println("�߸��� �����Դϴ�.");
					System.out.print("������ ������ �Է��ϼ���(���� ��ȣ 2��)");
					a = input.nextInt();
					b = input.nextInt();
				}
					
				graph.insertEdge(a,b);
			}
			else if(a==2)
			{
				System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
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
