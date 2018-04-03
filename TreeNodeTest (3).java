package hw;

//***************************
// 파일명:TreeNodeTest.java
// 작성자: 장승훈
// 작성일: 2016.11.22
// 프로그램 설명:변형 이진탐색트리를 추상자료형 IntegerBinarySearchTree 클래스를 정의하고 이용하는 프로그램이다.
//***************************


import java.util.Scanner;
public class TreeNodeTest {
	public static void main(String[] args) 
	{ 

		System.out.println("hw9_1");
		System.out.println("장승훈");

		System.out.println();
		System.out.println();

		int select;
		int result;
		BnarySearchTree bst = new BnarySearchTree();

		while(true){
			Scanner input=new Scanner(System.in);
			System.out.println("1:트리에 삽입  2:트리에서 삭제  3:트리에서 검색  4:중위순회  5:종료" );
			select= input.nextInt();

			if(select==1){
				System.out.println("삽입할 값을 입력하세요:");
				result= input.nextInt();     // 변수에 input에서 받은 데이터 저장 
				bst.add(result);
			}
			else if(select==2){
				System.out.println("삭제할 값을 입력하세요:");
				result= input.nextInt();     // 변수에 input에서 받은 데이터 저장 
				bst.deleteBST(result);
			}
			else if(select==3){
				System.out.println("찾는 값을 입력하세요:");
				result= input.nextInt();     // 변수에 input에서 받은 데이터 저장 
				bst.search(result);
			}
			else if(select==4){
				bst.printBST();
			}
			else if(select==5){
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			else{
				System.out.println("잘 못 입력하셨습니다. 다시 입력해 주세요");
			}
		}


	}
}


class TreeNode{
	int key;  // 키값
	int freq;  // 빈도수
	TreeNode left;
	TreeNode right;
}

class BnarySearchTree{

	private TreeNode root = null; 

	public void insertBst(int x){
		root=insertKey(root,x);

	}



	public TreeNode insertKey(TreeNode root ,int x){

		TreeNode p =root;

		TreeNode newNode = new TreeNode(); 

		newNode.key = x;
		newNode.left = null;
		newNode.right = null;
		newNode.freq=1;	


		if(p==null){
			return newNode;
		}


		else if(p.key==x){
			System.out.println("삽입 실패");
			p.freq++;
			return p;
		}

		else if(x<p.key){
			p.left=insertKey(p.left,x);
			return p;
		}

		else if(x>p.key){
			p.right=insertKey(p.right,x);
			return p;
		}


		else
			return p;

	}

	public void add(int x){

		this.insertBst(x);

		TreeNode p =root;
		TreeNode q=p;

		while(p !=null){

			if(x==p.key)


				q=p;
			if(x<p.key)
				p=p.left;   
			else 
				p=p.right;   

		}

		System.out.println("키:"+q.key+" : "+"빈도수:"+q.freq);
	}


	public TreeNode searchBST(int x){
		TreeNode p =root;

		while(p !=null){


			if(x<p.key)
				p=p.left;   
			else if(x>p.key)
				p=p.right; 
			else
				return p;

		}
		return p;

	}

	public void search(int x){
		TreeNode p=this.searchBST(x);

		if(p==null)
			System.out.println("찾는 값이 없습니다.");
		else
			System.out.println("키:"+p.key+" : "+"빈도수:"+p.freq);

	}


	public void deleteBST(int x){

		TreeNode p =root;
		TreeNode parent=p;

		while(p!=null){

			if(x<p.key){
				parent=p;
				p=p.left;
			}   			
			else if(x>p.key){
				parent=p;
				p=p.right;  
			}
			else
				break;

		}

		if(p==null)
			System.out.println("삭제 실패");
		
		if(p.left==null && p.right==null){
			if(parent==null)
				root=null;
			else if(parent.left==p)
				parent.left=null;
			else
				parent.right=null;
		}
		
		else if(p.left==null ^ p.right==null){
			if(p.left!=null){
				if(parent==null)
					p.left;
			}
		}
		
	}
	
	


	public void printBST(){
		inorder(root);
		System.out.println();
	}

	public void inorder(TreeNode root) 
	{
		if(root != null){
			inorder(root.left);
			System.out.println("키:"+root.key+" : "+"빈도수:"+root.freq); 
			inorder(root.right);
		}
	}

} 