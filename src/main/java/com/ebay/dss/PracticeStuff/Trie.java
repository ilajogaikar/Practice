package com.ebay.dss.PracticeStuff;

import java.util.*;

public class Trie {
    private TrieNode root;

    private class TrieNode {
        private Character character;
        private Boolean leaf = false;
        private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();

        private TrieNode() {

        }

        private TrieNode(Character c) {
            this.character = c;
        }
    }

    Trie() {
        this.root = new TrieNode();
    }

    void insertWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                TrieNode node = new TrieNode(c);
                curr.children.put(c, node);
            }
            curr = curr.children.get(c);
        }
        curr.leaf = true;
    }

    List<String> getWordsWithPrefix(String key, Map<String, String> map, Set<String> words) {
        List<String> out = new ArrayList<String>();

        StringBuilder sb = new StringBuilder(key);
        TrieNode curr = root;
        for (Character c : key.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return null;
            }
            curr = curr.children.get(c);
        }
        buildWords(curr, sb, out, map, words);

        return out;
    }

    private void buildWords(TrieNode node, StringBuilder sb, List<String> list, Map<String, String> map, Set<String> words) {
        if (node.leaf) {
            if (words.contains(sb.toString())) {
                list.add(sb.toString());
            }

            if (map.containsKey(sb.toString())) {
                list.add(map.get(sb.toString()));
            }
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            sb.append(entry.getKey());
            buildWords(entry.getValue(), sb, list, map, words);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    
    
    public static void main (String[] args) {
        String[] words = new String[]{"song", "sass", "sad",
                "savage", "i love sammy", "simplify", "sod", "sawed", "sow", "sample", "sap",
        "somebody like you", "summer fun", "simple things", "somethings fishy"};

        
        int M[][]= {  {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
            };
        
        System.out.println("M lenght : " +M.length);
        
        
       // List<String> list = autoComplete(words, "simp");
    }
}
