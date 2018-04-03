package lab5_3;

public class IntegerList {
	private int[] array;  	// 정수값을 저장할 배열
	private int size;	// 리스트 길이(배열에 저장된 정수값의 개수)
	private int capacity;	// 용량(배열의 크기)

	// 용량 10인 비어있는 리스트를 생성
	public IntegerList() 
	{
		capacity = 10;   
		size = 0;
		array = new int[capacity];
	}
	
	//인덱스에 저장된 나이를 리턴
	public int GetIndexAge(int index)
	{
		return array[index];
	}
	
	public void RemoveIndex(int index)
	{
		//사이즈 줄이고 temp에 입력
		for( int temp = --size ; temp>index ; index++) 
			array[index] = array[index+1];
	}

	// 리스트 길이를 리턴
	public int getSize() 
	{
		return size;
	}

	// 리스트의 맨 뒤에 자료를 삽입(배열의 맨 끝에 삽입하는 것이 아님)
	public void add(int item) 
	{
		if(size == capacity)   // 용량 초과시 자동으로 리스트 용량을 증가시킴
			increaseCapacity();
		array[size++] = item;
	}

	// 리스트 용량을 2배로 증가
	private void increaseCapacity() 
	{
		capacity = capacity * 2;		
		int[] newArray = new int[capacity];
		for(int i=0; i<size; i++)
			newArray[i] = array[i];
		array = newArray;
	}

	// 리스트의 자료들을 순서대로 출력
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
		return "길이 : "+size+" || 내용 : ["+a+"]";
	}
}