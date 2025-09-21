class Solution {
    private Map<String, List<String>> flightGraph; // Represents flights from one airport to another
    private List<String> travelItinerary; // Stores the final travel itinerary

    public List<String> findItinerary(List<List<String>> tickets) {
        flightGraph = new HashMap<>();
        travelItinerary = new ArrayList<>() ;
        for (List<String> ticket : tickets) {
            String fromAirport = ticket.get(0);
            String toAirport = ticket.get(1);
            flightGraph.computeIfAbsent(fromAirport, k -> new ArrayList<>()).add(toAirport);
        }

        for (List<String> destinations : flightGraph.values()) {
            destinations.sort(Collections.reverseOrder());
        }

        Stack<String> dfsStack = new Stack<>();
        dfsStack.push("JFK");

        while (!dfsStack.isEmpty()) {
            String currentAirport = dfsStack.peek();
            List<String> destinations = flightGraph.get(currentAirport);

            if (destinations != null && !destinations.isEmpty()) {
                String nextDestination = destinations.remove(destinations.size() - 1);
                dfsStack.push(nextDestination);
            } else {
                travelItinerary.add(currentAirport);
                dfsStack.pop();
            }
        }
        Collections.reverse(travelItinerary);
        return travelItinerary;
    }
}