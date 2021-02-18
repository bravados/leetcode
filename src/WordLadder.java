import java.util.*;

public class WordLadder {

    private boolean matches(String word1, String word2) {
        int diff = 0;

        for (int i = 0; i < word1.length(); i++)
            if (word1.charAt(i) != word2.charAt(i))
                diff++;

        return diff == 1;
    }

    private int shortestSequence(Map<String, Set<String>> graph, String end, Set<String> visited, Set<String> lastAdded, int step) {
        if (visited.contains(end)) return step;

        Set<String> related = new HashSet<>();
        for (String s : lastAdded)
            if (graph.containsKey(s)){
                Set<String> nodes = graph.get(s);
                nodes.removeAll(visited);
                related.addAll(nodes);
            }


        if(related.isEmpty()) return 0;

        visited.addAll(related);

        return shortestSequence(graph, end, visited, related, step + 1);
   }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        list.addAll(wordList);

        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++) {
                String word1 = list.get(i);
                String word2 = list.get(j);

                if (matches(word1, word2)) {
                    graph.computeIfAbsent(word1, s -> new HashSet<>()).add(word2);
                    graph.computeIfAbsent(word2, s -> new HashSet<>()).add(word1);
                }
            }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        return shortestSequence(graph, endWord, visited, visited, 1);
    }

    public static void main(String args[]){
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log", "cog")));
    }
}
