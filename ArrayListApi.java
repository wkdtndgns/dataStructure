package hw5_3;

import java.util.*;

public class ArrayListApi
{
	public static void main(String[] args)
	{
		System.out.println("hw5_3 ������");
		ArrayList<String> str1 = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		
		String a;//���� ����
		int num1; //�Է��� ���� ����

		while(true)
		{
			System.out.println("1:�ǵڻ��� 2:�ε����λ��� 3:���� 4:�ε�������ȸ 5:��ü��� 6:����");
			System.out.println("���ڸ� �Է��Ͻÿ� :");
			
			num1 = input.nextInt();
			input.nextLine(); // ���� ����
			
			if(num1<=0 || num1>6)
			{ 
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
			if(num1==1)
			{
				System.out.println("�ܾ �Է��ϼ��� :");
				str1.add(input.nextLine());
			}
			else if(num1==2) 
			{
				System.out.println("0~"+str1.size()+"(����) ������ ���ڸ� �Է��ϼ���.");
				num1 = input.nextInt();
				input.nextLine(); // ���� ����
				System.out.println("�ܾ �Է��ϼ��� :");
				str1.add(num1,input.nextLine());
			}
			else if(num1==3) // 3 ���ý� ����ڷκ��� �ܾ �Է¹޾� ����
			{
				int b=-1;
				System.out.println("������ �ܾ �Է��ϼ���.");
				b=str1.indexOf(input.nextLine());
				if(b == -1)
				{
					System.out.println("������ �ܾ ��Ͽ� �����ϴ�.");
					continue;
				}
				str1.remove(b);
			}
			else if(num1==4) //4:�ε�������ȸ
			{
				System.out.println("���Ͻô� �ε����� ��ȸ�ص帳�ϴ� :");
				System.out.println(str1.get(input.nextInt()));
			}
			else if(num1==5)
			{
				System.out.print("���� : "+str1.size()+" || ���� : [ ");
				for(String temp : str1)
					System.out.print(temp+" ");
				System.out.println("]");
			}
			else // 6 �� ���
				break;
		}
		System.out.println("�����մϴ�.");
	}
}
