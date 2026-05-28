class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int idx;
        int len;

        TrieNode() {
            idx = -1;
            len = Integer.MAX_VALUE;
        }
    }

    TrieNode root = new TrieNode();

    private void update(TrieNode node, int index, int length) {
        if (length < node.len || 
           (length == node.len && index < node.idx)) {
            node.len = length;
            node.idx = index;
        }
    }

    private void insert(String word, int index) {
        TrieNode node = root;
        update(node, index, word.length());

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }

            node = node.children[c];
            update(node, index, word.length());
        }
    }

    private int search(String word) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.children[c] == null) {
                break;
            }

            node = node.children[c];
        }

        return node.idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}