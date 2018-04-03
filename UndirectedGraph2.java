package hw10_1;

public class UndirectedGraph2 
{
	private Node[] list;
	private int n; // vertex 개수
	private boolean[] visited;

	public UndirectedGraph2(int n) 
	{
		list = new Node[n];
		visited = new boolean[n];
		this.n = n;
	}

	private class Node
	{
		int vertex;
		Node link;
	}
	
	public boolean TorF(int v1, int v2)  //보너스 과제 True or False
	{
		if(v1<0 || v1>=n || v2<0 || v2>=n)
			return true;
		
		for(Node temp = list[v1];temp!=null;temp=temp.link)
			if(temp.vertex==v2)
				return true;
		
		for(Node temp = list[v2];temp!=null;temp=temp.link)
			if(temp.vertex==v1)
				return true;
		
		return false;
	}

	public void insertEdge(int v1, int v2) 
	{
		if(v1<0 || v1>=n || v2<0 || v2>=n)
			System.out.println("그래프에 없는 정점입니다!");
		else 
		{
			// vertex가 v2인 새로운 노드를 v1의 연결리스트 맨 앞에 삽입
			Node newNode1 = new Node();
			newNode1.vertex = v2;
			newNode1.link = list[v1];
			list[v1] = newNode1;

			Node newNode2 = new Node();
			newNode2.vertex = v1;
			newNode2.link = list[v2];
			list[v2] = newNode2;

		}
	}

	public void depthFirstSearch()
	{
		for(int i=0;i<n;i++)
			visited[i]= false;

		for(int i =0 ;i<n ;i++)
			if(visited[i]==false)
				aDFS(i);

		System.out.println();
	}
	public void aDFS(int i)
	{
		visited[i]=true;
		System.out.print(i+" ");

		for(Node temp = list[i];temp!=null;temp=temp.link)
			if(visited[temp.vertex]==false)
				aDFS(temp.vertex);
	}

	public void printAdjacentVertecies(int a) 
	{
		for(Node temp = list[a]; temp != null; temp = temp.link)
			System.out.print(" "+ temp.vertex);

		System.out.println();
	}
}

