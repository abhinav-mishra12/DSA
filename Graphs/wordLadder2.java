import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class wordLadder2 {
    public static void main(String[] args) {

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord)) return result;

        // Build graph via BFS
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, wordSet, graph, distance);

        // Use DFS to recover all shortest paths
        List<String> path = new ArrayList<>();
        path.add(beginWord);

        dfs(beginWord, endWord, graph, distance, path, result);

        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet,
                     Map<String, List<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int currentDistance = distance.get(word);

            for (String neighbor : getNeighbors(word, wordSet)) {
                graph.computeIfAbsent(word, k -> new ArrayList<>()).add(neighbor);

                // If neighbor is seen first time
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, currentDistance + 1);
                    queue.offer(neighbor);
                }
            }
        }
    }

    private void dfs(String currentWord, String endWord,
                     Map<String, List<String>> graph,
                     Map<String, Integer> distance,
                     List<String> path,
                     List<List<String>> result) {

        if (currentWord.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (!graph.containsKey(currentWord)) return;

        for (String neighbor : graph.get(currentWord)) {
            // Only go forward if it's one step further (shortest path)
            if (distance.get(neighbor) == distance.get(currentWord) + 1) {
                path.add(neighbor);
                dfs(neighbor, endWord, graph, distance, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }

            chars[i] = originalChar;
        }

        return neighbors;
    }
}
        
    }
}
