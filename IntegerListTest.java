package lab5_3;

import java.util.Scanner;

public class IntegerListTest {
	public static void main(String[] args) 
	{
		System.out.println("lab5_3: ������");
		System.out.println("�������� ���̸� �ٷ�� ���α׷��Դϴ�.");

		// ���̸� �����ϱ� ���� ����ִ� ���� ����Ʈ ����
		IntegerList ageList = new IntegerList(); 

		// ���̸� �Է¹޾� ����Ʈ�� ����
		Scanner in = new Scanner(System.in);
		int index;
		System.out.println("���̸� �����Ͽ� �Է��ϼ���(�������� �Է��ϸ� �����մϴ�).");
		int age = in.nextInt();
		while(age >= 0) {
			ageList.add(age);
			age = in.nextInt();
		}
		
		// ���� ����Ʈ ���̿� ������ ���
		System.out.println("���� ����Ʈ�� ������ �����ϴ�.");
		System.out.println("����: " + ageList.getSize());
		System.out.print("����: ");
		ageList.printList();

		
		//�ε����� ���̸� �˷���
		while(true)
		{
			System.out.println(0+"~"+(ageList.getSize()-1)+" ������ ���ϴ� �ε����� �Է��ϸ� ���̸� �˷��帳�ϴ� :");
			index = in.nextInt();
			if(index<0 || index>ageList.getSize())
			{
				System.out.println(0+"~"+(ageList.getSize()-1)+" ������  �ε����� �ٽ� �Է����ּ���.");
				continue;
			}
			else
				break;
		}
		System.out.println(index+"�� �ε����� ���̴� "+ageList.GetIndexAge(index)+"�Դϴ�.");
		
		//�ε��� ����
		while(true)
		{
			System.out.println(0+"~"+(ageList.getSize()-1)+" ������ ���ϴ� �ε����� �Է��ϸ� �����ص帳�ϴ� :");
			index = in.nextInt();
			if(index<0 || index>ageList.getSize())
			{
				System.out.println(0+"~"+(ageList.getSize()-1)+" ������  �ε����� �ٽ� �Է����ּ���.");
				continue;
			}
			else
				break;
		}
		ageList.RemoveIndex(index);
		
		System.out.println(ageList.toString());
		
	




	}
}
