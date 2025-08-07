// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

// Example 1:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
// Example 2:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class wordLadder {
    public static void main(String[] args) {
        class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //Converts wordList into a HashSet for fast O(1) lookups.

        if(!wordSet.contains(endWord)) return 0; //End word not reachable

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                String word = queue.poll();

                char[] wordChars = word.toCharArray(); //Converting the word into a character array

                for(int j=0; j<wordChars.length; j++){
                    char originalCharacter = wordChars[j]; // save the original character so we can restore it later
                    for(char c='a'; c<='z'; c++){
                        if(c==originalCharacter) continue;
                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        if(newWord.equals(endWord)){
                            return level+1;
                        }
                        if(wordSet.contains(newWord)){
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }

                    wordChars[j] = originalCharacter;
                }
            }
            level++;
        }
        return 0;


    }
}
    }
}
