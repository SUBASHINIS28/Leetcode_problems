class Solution 
{
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> graph[];
    int disc[];
    int low[];
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        graph = new ArrayList[n];
        disc=new int[n];
        low = new int[n];
        Arrays.fill(disc,-1);
        Arrays.fill(low,-1);
        time=0;
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(List<Integer> con:connections)
        {
            int s = con.get(0);
            int d = con.get(1);
            graph[s].add(d);
            graph[d].add(s);      
        }
        func(0,-1);
        return ans;     
    }
    public void func(int current, int parent)
    {
        disc[current]=time;
        low[current]=time;
        time++;
        for(int child:graph[current])
        {
            if(child==parent)continue;
            if(disc[child]==-1)
            {
                func(child,current);
                low[current]=Math.min(low[current],low[child]);
                if(low[child]>disc[current])
                {
                    ans.add(Arrays.asList(current,child));
                }
            }
            else
            {
                low[current]=Math.min(low[current],low[child]);
            }
        }
    }
}