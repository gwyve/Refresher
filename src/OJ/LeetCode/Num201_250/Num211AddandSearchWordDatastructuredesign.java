package OJ.LeetCode.Num201_250;

public class Num211AddandSearchWordDatastructuredesign {
    private class TrieNode{
        boolean isWord;
        TrieNode[] childrend = new TrieNode[26];
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Num211AddandSearchWordDatastructuredesign() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode run = this.root;
        for (int i = 0; i < word.length(); i++) {
            int tmp = word.charAt(i) - 'a';
            if (run.childrend[tmp] == null)
                run.childrend[tmp] = new TrieNode();
            run = run.childrend[tmp];
        }
        run.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word,root,0);
    }

    public boolean search(String word, TrieNode trieNode, int i){
        if (i==word.length()-1){
            if (word.charAt(i) == '.'){
                for (TrieNode node:trieNode.childrend){
                    if (node!=null)
                        return node.isWord;
                }
            }else {
                int tmp = word.charAt(i) - 'a';
                if (trieNode.childrend[tmp] != null){
                    return trieNode.childrend[tmp].isWord;
                }else {
                    return false;
                }
            }
        }

        TrieNode run = trieNode;
        for (int j = i; j < word.length(); j++) {
            if (word.charAt(j) == '.'){
                boolean res = false;
                for (TrieNode node:run.childrend){
                    if (node!=null){
                        res = res || search(word,node,j+1);
                    }
                }
                return res;
            }else {
                int tmp = word.charAt(j) - 'a';
                if (run.childrend[tmp] == null)
                    return false;
                else {
                    run = run.childrend[tmp];
                }
            }
        }
        return run.isWord;
    }
    public static void main(String[] args){
        Num211AddandSearchWordDatastructuredesign obj = new Num211AddandSearchWordDatastructuredesign();
        obj.addWord("dad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("dad"));
        System.out.println(obj.search("d.d"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("."));
    }

}