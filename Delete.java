//***************************
// 파일명: Delete.java
// 작성자: 장승훈
// 작성일: 2016.09.23
// 설명: 정수 배열로 구현한 선형리스트에서 사용자가 원하는 (1)위치(인덱스)의 값을 삭제하고, (2)사용자가 원하는 값을 삭제하는 프로그램을 작성하시오.
//***************************



package hw;

import java.util.Scanner;

public class Delete {

	public static void main(String[] args){

		int[] numArrays=new int[100];	//크기가 100인 배열 선언 
		int count=0;		//  배열의 길이를 재기위해 카운터선언 초기화
		int result;
		int pull=0;
		int before=0;

		for(int i=0; i<10; i++){		//배열에 값을 저장하기 위해 for문 돌림 	

			numArrays[i]=i*11;		// 0 11 22 33 44 55 66 77 88 99 값 저장	
			count++;				//카운터 증가	
		}


		System.out.println("hw5_2 장승훈"); 
		System.out.println();

		System.out.println("초기 리스트");
		System.out.println("배열의 길이 :" +count);

		System.out.print("내용: ");

		for(int i=0; i<count; i++){				// 배열의 저장된 길이만큼 반복문 돌림	
			System.out.print(numArrays[i] );	
			System.out.print(" ");
		}


		System.out.println(); 
		System.out.println(); 


		Scanner input=new Scanner(System.in);		// 데이터를 받아 input에 저장 
		System.out.println("삭제할 값을 입력하세요:");
		result= input.nextInt();		//실적 변수에 input에서 받은 데이터 저장 

		
		if(0<=result && result<=9){			//result 값이 0과 같거나 크고 9보다 작거나 같을떄 
			
			for(int i=0; i<count; i++){
				
				if(i==result){
					
					numArrays[i]=0;		// 값을 0으로 만들고
					count--;			// 길이를 하나 뺴준다	
					pull=i;				// 몇번쨰 값인지를 pull에 저장	
					
					
					for(int k=pull; k<count; k++){	//반복문 안에 있어서 i를 k로 바꿈  위에서 받은 pull로 count보다 커지기 전까지의 조건

						before=numArrays[k+1];		// 삭제된 값의 앞의 값을 before에다 넣는다  
						numArrays[k]=before;		// before의 받은 값을 삭제된 값에다 넣는다   
														
					}
					
					
				}
				
				
			}
			
		}

		
		else {			//result 위에 조건과 다를떄 
			
			for(int i=0; i<count; i++){
				
				if(numArrays[i]==result){		//result의 값과 배열의 값이 맞을 경우
					
					numArrays[i]=0;		// 값을 0으로 만들고
					count--;			// 길이를 하나 뺴준다	
					pull=i;				// 몇번쨰 값인지를 pull에 저장	
					
					for(int k=pull; k<count; k++){	//반복문 안에 있어서 i를 k로 바꿈  위에서 받은 pull로 count보다 커지기 전까지의 조건

						before=numArrays[k+1];		// 삭제된 값의 앞의 값을 before에다 넣는다  
						numArrays[k]=before;		// before의 받은 값을 삭제된 값에다 넣는다   
														
					}
					
					break;										
					
				}									
			}	
			
			
						
		}
		
		if(count==10){
			System.out.println("삭제된 값이 없습니다.");
		}
		
		
		
		
		System.out.println("삭제 후 리스트");
		System.out.println("배열의 길이 :" +count);

		System.out.print("내용: ");

		for(int i=0; i<count; i++){				// 배열의 저장된 길이만큼 반복문 돌림	
			System.out.print(numArrays[i] );	
			System.out.print(" ");
		}	
		
		


	}
}