class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (graph.containsKey(from)) {
                graph.get(from).offer(to);
            } else {
                PriorityQueue<String> q = new PriorityQueue<>();
                q.offer(to);
                graph.put(from, q);
            }
        }
        dfs("JFK");
        return result;
    }

    private void dfs(String airport) {
        PriorityQueue<String> arrivals = graph.get(airport);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        result.addFirst(airport);
    }
}