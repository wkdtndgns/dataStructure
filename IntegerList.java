package lab5_3;

public class IntegerList {
	private int[] array;  	// �������� ������ �迭
	private int size;	// ����Ʈ ����(�迭�� ����� �������� ����)
	private int capacity;	// �뷮(�迭�� ũ��)

	// �뷮 10�� ����ִ� ����Ʈ�� ����
	public IntegerList() 
	{
		capacity = 10;   
		size = 0;
		array = new int[capacity];
	}
	
	//�ε����� ����� ���̸� ����
	public int GetIndexAge(int index)
	{
		return array[index];
	}
	
	public void RemoveIndex(int index)
	{
		//������ ���̰� temp�� �Է�
		for( int temp = --size ; temp>index ; index++) 
			array[index] = array[index+1];
	}

	// ����Ʈ ���̸� ����
	public int getSize() 
	{
		return size;
	}

	// ����Ʈ�� �� �ڿ� �ڷḦ ����(�迭�� �� ���� �����ϴ� ���� �ƴ�)
	public void add(int item) 
	{
		if(size == capacity)   // �뷮 �ʰ��� �ڵ����� ����Ʈ �뷮�� ������Ŵ
			increaseCapacity();
		array[size++] = item;
	}

	// ����Ʈ �뷮�� 2��� ����
	private void increaseCapacity() 
	{
		capacity = capacity * 2;		
		int[] newArray = new int[capacity];
		for(int i=0; i<size; i++)
			newArray[i] = array[i];
		array = newArray;
	}

	// ����Ʈ�� �ڷ���� ������� ���
	public void printList() 
	{
		for(int i=0; i<size; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	@Override
	public String toString()
	{
		String a = " ";
		for(int i=0; i<size ; i++ )
			a = a + array[i]+" ";
		return "���� : "+size+" || ���� : ["+a+"]";
	}
}