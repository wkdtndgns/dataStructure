
package hw;

//***************************
//파일명:TreeNodeTest.java
//작성자: 장승훈
//작성일: 2016.11.23
//프로그램 설명:hw9_1의 정수 이진탐색트리에 삭제 기능과 검색 기능을 추가하고, 이를 이용하는 프로그램을 다음과 같이 작성하시오.
//***************************

import java.util.Scanner;
public class TreeNodeTest {
	public static void main(String[] args) 
	{
		System.out.println("hw9_2");
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

				if(bst.searchResult(result)==true)
					bst.delete(result);								
				else
					System.out.println("삭제할 값이 없습니다.");

			}
			else if(select==3){
				System.out.println("찾는 값을 입력하세요:");
				result= input.nextInt();     // 변수에 input에서 받은 데이터 저장 
				bst.search(result);
			}
			else if(select==4){
				bst.getRoot();
				System.out.println();
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

	public boolean searchResult(int x){
		TreeNode p=this.searchBST(x);
		if(p==null)
			return false;

		else
			return true;

	}


	public TreeNode deleteBST(TreeNode bst,int x){
		
		TreeNode p =bst;
		TreeNode parent=null;
		
		while(p!=null){
			if(x<p.key){
				parent=p;
				p=p.left;
			}      
			else if(x>p.key){
				parent=p;
				p=p.right;  
			}
			else if(x==p.key)
				break;
		}

		

		if(p==null)
			System.out.println("삭제 실패");
		
		else{

			if(p.left==null && p.right==null){		//자식노드가 없을떄	

				if(parent==null)
					return null;		
				else if(parent.left==p)
					parent.left=null;
				else
					parent.right=null;
			}

			else if(p.left==null || p.right==null){		//둘 중 하나만 자식이 있을떄 
				if(p.left!=null){
					if(parent==null)
						return p.left;
					else if(parent.left==p)
						parent.left=p.left;
					else 
						parent.right=p.left;
				}

				else{
					if(parent==null)
						return p.right;
					else if(parent.left==p)
						parent.left=p.right;
					else
						parent.right=p.right;  
				}
			}
			else {	//두개의 자식노드를 가지고 있음

				TreeNode q=minNode(p);
				p.key=q.key; 
				p.right=deleteBST(p.right,q.key);
			}
		}
		
		return bst;

	}

	
	public void delete(int x){
		
		root=deleteBST(root,x);					
	}

	public void getRoot(){
		
		if(root==null)
			System.out.println("루트 값이 존재하지 않습니다.");
		
		else 				
			System.out.println("루트 값: " +root.key);
	}

	public TreeNode minNode(TreeNode p){  
		TreeNode q = new TreeNode();

		p=p.right;

		while(p!=null){
			q=p;
			p=p.left;				
		}							

		return q;
	}

	public void minNodeTest(){
		System.out.println(minNode(root).key);

	}

	public void printBST(){

		if(root==null)
			System.out.println("트리가 존재하지 않습니다.");
		else{
			inorder(root);
			System.out.println();
		}

	}
	public void inorder(TreeNode root) {

		if(root != null){
			inorder(root.left);
			System.out.println("키:"+root.key+" : "+"빈도수:"+root.freq); 
			inorder(root.right);
		}
	}
}  