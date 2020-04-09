class MainAlgorithm { 
	int graph[][]=new int [10][10];
	int parent[] = new int[10];
	int num;
	int coor[][]=new int [10][10];

	public MainAlgorithm(int g[][],int n,int c[][]) {
		graph=g;
		num=n;
		coor=c;
	}
   
    int minKey(int key[], Boolean mstSet[]) 
    { 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < num; v++) 
            if (mstSet[v] == false && key[v] < min) { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    void printMST(int parent[], int graph[][]) 
    { 
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < num; i++) 
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 
    } 
  
    void primMST() 
    { 
        int key[] = new int[num]; 
        Boolean mstSet[] = new Boolean[num]; 
  
        for (int i = 0; i < num; i++) { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
  
        key[0] = 0;  
        parent[0] = -1; 
 
        for (int count = 0; count < num - 1; count++) {  
            int u = minKey(key, mstSet);  
            mstSet[u] = true;  
            for (int v = 0; v < num; v++) 
  
                
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 
        
        OutputScreen os=new OutputScreen(graph, parent, num, coor);
        printMST(parent, graph); 
    } 
  
    
}


