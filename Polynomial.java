//***************************
// 파일명: Polynomial.java
// 작성자: 장승훈
// 작성일: 2016.09.28
// 설명: 교재의 1차원 배열을 이용한 다항식 표현을 이용하여
//		아래 다항식(Ai, Bi)을 더하여 새로운 다항식(Ci)를 구하고 그 계수를 출력하는 프로그램을 작성하시오.
//		(희소다항식 표현으로 하지 말 것)
//***************************




package hw;


class AddPolynomial{		//클래스 선언
	
	double[] c;			// 다항식의 합한 값을 저장할 배열 선언
	int gap;			// 서로의 차이를 알아낼 변수 선언

	
	public AddPolynomial(double [] A, double[] B){
				
		if(A.length==B.length){		//A배열과 B배열의 길이가 같을 경우 
			
			c = new double[A.length];		//c배열의 길이를 받은 배열의 길이 중 최대 길이로 바꾼다 
			
			for(int i=0; i<A.length;i++)		
				c[i]=A[i]+B[i];			//c[i]에  a[i]+b[i]의 값을 집어넣음	
			
		}
		
		else if(A.length>B.length){			//A배열의 길이가 더 클경우 
			
			c = new double[A.length];		//c배열의 길이를 받은 배열의 길이 중 최대 길이로 바꾼다 
			gap=A.length-B.length;			
			
			for(int i=0; i<gap; i++)		//gap의 차이만큼 일단 A값을 C에 집어 넣는다 
				c[i]=A[i];
			
			for(int i=0; i<B.length;i++)		
				c[i+gap]=A[i+gap]+B[i];			//gap차이만큼 집어넣고 난 뒤 다항식 덧셈을 시작한다 
			
			
		}
		
		else{								//B배열의 길이가 더 클경우
			
			c = new double[B.length];		//c배열의 길이를 받은 배열의 길이 중 최대 길이로 바꾼다 
			gap=B.length-A.length;			
			
			for(int i=0; i<gap; i++)		//gap의 차이만큼 일단 B값을 C에 집어 넣는다 
				c[i]=B[i];
			
			for(int i=0; i<A.length;i++)		
				c[i+gap]=A[i]+B[i+gap];			//gap차이만큼 집어넣고 난 뒤 다항식 덧셈을 시작한다 
			
			
		}
				
	}
	

	
	@Override
	public String toString(){
			
		String s = "";		// return 출력하기 위한 s선언 초기화
		for(int i=0; i<c.length ; i++ )
			s = s + c[i]+"  ";	// s에 배열의 값 모두 저장 
		
		return "내용 : "+s ;					
	}
	
	
	
}


public class Polynomial {

	public static void main(String args[]){

		
		double[] A1={ 9, 4, 5, 0};
		double[] B1={ 8, 1, -3, 2.5, 1.8};

		double[] A2={ 3, 4, 5, 6, 7};
		double[] B2={ -3, -4, 4, 6, 0};
		
		double[] A3={ 7, -6, 5, 3, 3, 1.5, 2.5};
		double[] B3={ 6, 3, 2, 1, 0, 7, -2.5};
		
		AddPolynomial p1 =new AddPolynomial(A1, B1);
		AddPolynomial p2 =new AddPolynomial(A2, B2);
		AddPolynomial p3 =new AddPolynomial(A3, B3);
		
		
		System.out.println("hw5_4: 장승훈");
		System.out.println();
		System.out.println();
		
	
		System.out.println("C1 "+p1.toString());
		System.out.println("C2 "+p2.toString());
		System.out.println("C3 "+p3.toString());
	}

}

