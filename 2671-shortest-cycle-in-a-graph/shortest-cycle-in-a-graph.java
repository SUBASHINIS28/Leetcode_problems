class Solution 
{
    int mincycle=Integer.MAX_VALUE;
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int edge[]:edges){
            int s=edge[0];
            int d=edge[1];
            graph[s].add(d);
            graph[d].add(s);
        }
        int node_pos[]=new int[n];
        Arrays.fill(node_pos,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            func(i,-1,graph,node_pos,0);
        }
        if(mincycle==Integer.MAX_VALUE){
            return -1;
        }else{
            return mincycle;
        }
    }
    public void func(int curr,int parent,List<Integer> graph[],int node_pos[],int pos){
        pos++;
        node_pos[curr]=pos;
        for(int child :graph[curr]){
            if(child==parent)   continue;
            if(node_pos[child]>pos+1){
                func(child,curr,graph,node_pos,pos);
            }else if(node_pos[child]<pos){
                mincycle=Math.min(mincycle,pos-node_pos[child]+1);
            }
        }
    }
}