class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(0, rooms, visited);
        return visited.size() == rooms.size();
    }
    private void dfs(int room, List<List<Integer>> rooms, Set<Integer> visited) {
        if (visited.contains(room)) return;
        visited.add(room);
        for (int key : rooms.get(room)) {
            dfs(key, rooms, visited);
        }
    }
}