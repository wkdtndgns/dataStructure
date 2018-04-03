//***************************
// 파일명: Insertion.java
// 작성자: 장승훈
// 작성일: 2016.09.22
// 설명: 정수 배열로 구현한 선형리스트에 값을 삽입하는 프로그램을 작성하시오.
//***************************


package hw;

import java.util.Scanner;

public class Insertion {

	public static void main(String[] args){


		int[] numArrays=new int[100];	//크기가 100인 배열 선언 
		int count=0;		//  배열의 길이를 재기위해 카운터선언 초기화
		int result;			// 값을 받을 수 있도록 변수 선언 		
		int pull=0;			// 몇 번쨰 부터 값이 밀릴지 알 수있는 변수 선언 
		int before=0;		//  배열 값을 바꾸기 위한 변수 선언 


		for(int i=0; i<10; i++){		//배열에 값을 저장하기 위해 for문 돌림 	

			numArrays[i]=i*11;		// 0 11 22 33 44 55 66 77 88 99 값 저장	
			count++;				//카운터 증가	
		}


		System.out.println("hw5_1 장승훈"); 
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
		System.out.println("삽입할 값을 입력하세요:");
		result= input.nextInt();		//실적 변수에 input에서 받은 데이터 저장 

		count=0;	  

		if(numArrays[9]<result){		// 삽입한 값이 배열의 끝 값보다 클떄 

			for(int i=0; i<10; i++){
				numArrays[i]=i*11;		// 0 11 22 33 44 55 66 77 88 99 값 저장	
				count++;				//카운터 증가	
			}
			numArrays[count]=result;	//배열의 끝에 저장 	
			count++;	

		}

		else if(numArrays[0]>=result){	 	//삽입한 값이 0보다 작거나 같을떄					  

			numArrays[0]=result;	// 받은 값 배열 맨 앞에 저장 

			for(int i=0; i<11; i++){
				numArrays[i+1]=i*11;		// 0 11 22 33 44 55 66 77 88 99 값 저장	
				count++;				//카운터 증가	
			}

		}

		else{			// 삽입한 값이 배열 사이의 값일 경우 

			for(int i=0; i<11; i++){	


				if(numArrays[i]<result && numArrays[i+1]>result){	// 삽입한 값이 [i]와 [i+1] 사이의 값일 떄 조건 

					numArrays[i]=result;	// 받은 값을 삽입
					pull=i;		//값을 받고 밀기 위해 
					count++;	

				}

				else{		// 위와 동일
					numArrays[i]=i*11;
					count++;

				}

			}
			
			for(int i=count; i>pull-1; i--){	//삽입한 값 이후로 밀기 위한 조건문 

				before=numArrays[i];		// i 값을 받는다 	
				numArrays[i+1]=before;		// i+1 값에  i값을 넣는다 
			}

			numArrays[pull]=pull*11;		// 밀려서 삭제된 [pull]에 원래 값 삽입 
			

		}		



		System.out.println("삽입 후  리스트"); 
		System.out.println("배열의 길이 :" +count);

		System.out.print("내용: ");




		for(int i=0; i<count; i++){			// 배열 출력 
			System.out.print(numArrays[i] );
			System.out.print(" ");
		}



	}

}