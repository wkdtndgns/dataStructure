
package hw;

//***************************
//���ϸ�:TreeNodeTest.java
//�ۼ���: �����
//�ۼ���: 2016.11.23
//���α׷� ����:hw9_1�� ���� ����Ž��Ʈ���� ���� ��ɰ� �˻� ����� �߰��ϰ�, �̸� �̿��ϴ� ���α׷��� ������ ���� �ۼ��Ͻÿ�.
//***************************

import java.util.Scanner;
public class TreeNodeTest {
	public static void main(String[] args) 
	{
		System.out.println("hw9_2");
		System.out.println("�����");
		System.out.println();
		System.out.println();
		int select;
		int result;
		BnarySearchTree bst = new BnarySearchTree();
		while(true){
			Scanner input=new Scanner(System.in);
			System.out.println("1:Ʈ���� ����  2:Ʈ������ ����  3:Ʈ������ �˻�  4:������ȸ  5:����" );
			select= input.nextInt();

			if(select==1){

				System.out.println("������ ���� �Է��ϼ���:");
				result= input.nextInt();     // ������ input���� ���� ������ ���� 
				bst.add(result);

			}
			else if(select==2){

				System.out.println("������ ���� �Է��ϼ���:");
				result= input.nextInt();     // ������ input���� ���� ������ ���� 

				if(bst.searchResult(result)==true)
					bst.delete(result);								
				else
					System.out.println("������ ���� �����ϴ�.");

			}
			else if(select==3){
				System.out.println("ã�� ���� �Է��ϼ���:");
				result= input.nextInt();     // ������ input���� ���� ������ ���� 
				bst.search(result);
			}
			else if(select==4){
				bst.getRoot();
				System.out.println();
				bst.printBST();
			}
			else if(select==5){
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			else{
				System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���");
			}
		}

	}
}

class TreeNode{
	int key;  // Ű��
	int freq;  // �󵵼�
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
			System.out.println("���� ����");
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
		System.out.println("Ű:"+q.key+" : "+"�󵵼�:"+q.freq);
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
			System.out.println("ã�� ���� �����ϴ�.");

		else
			System.out.println("Ű:"+p.key+" : "+"�󵵼�:"+p.freq);

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
			System.out.println("���� ����");
		
		else{

			if(p.left==null && p.right==null){		//�ڽĳ�尡 ������	

				if(parent==null)
					return null;		
				else if(parent.left==p)
					parent.left=null;
				else
					parent.right=null;
			}

			else if(p.left==null || p.right==null){		//�� �� �ϳ��� �ڽ��� ������ 
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
			else {	//�ΰ��� �ڽĳ�带 ������ ����

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
			System.out.println("��Ʈ ���� �������� �ʽ��ϴ�.");
		
		else 				
			System.out.println("��Ʈ ��: " +root.key);
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
			System.out.println("Ʈ���� �������� �ʽ��ϴ�.");
		else{
			inorder(root);
			System.out.println();
		}

	}
	public void inorder(TreeNode root) {

		if(root != null){
			inorder(root.left);
			System.out.println("Ű:"+root.key+" : "+"�󵵼�:"+root.freq); 
			inorder(root.right);
		}
	}
}  