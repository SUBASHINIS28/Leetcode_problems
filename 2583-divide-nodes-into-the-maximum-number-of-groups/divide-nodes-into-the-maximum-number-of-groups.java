class Solution {
    public int magnificentSets(int n, int[][] edges) {
        // ArrayList[n+1]
        // degree[n+1]
        // component[]
        // result[max grp][low degree]
        // level[]
        List<Integer> graph[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        int degree[]=new int[n+1];
        for(int edge[]:edges){
            int s=edge[0];
            int d=edge[1];
            graph[s].add(d);
            graph[d].add(s);
            degree[s]++;
            degree[d]++;
        }
        int comp[]=new int[n+1];
        int res[][]=new int[n+1][2];
        int component=1;
        for(int i=1;i<=n;i++){
            if(comp[i]!=0 && res[comp[i]][1]<degree[i]) continue;
            if(comp[i]==0){
                comp[i]=component++;
            }
            res[comp[i]][1]=degree[i];
            Queue<Integer> q=new LinkedList<>();
            q.offer(i);
            int level[]=new int[n+1];
            level[i]=1;
            int h=0;
            while(!q.isEmpty()){
                int size=q.size();
                for(int j=0;j<size;j++){
                    int parent=q.poll();
                    comp[parent]=comp[i];
                    h=Math.max(h,level[parent]);
                    for(int child:graph[parent]){
                        if(level[child]==0){
                            level[child]=level[parent]+1;
                            q.offer(child);
                        }
                        else if(Math.abs(level[parent]-level[child])!=1){
                            return -1;
                        }
                    }
                }
            }
            res[comp[i]][0]=Math.max(res[comp[i]][0],h);
        }
        int ans=0;
        for(int arr[]:res){
            ans+=arr[0];
        }
        return ans;
    }
}