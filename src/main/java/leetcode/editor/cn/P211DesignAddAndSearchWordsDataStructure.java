/**
 * 题目Id：211
 * 题目：添加与搜索单词 - 数据结构设计
 * 内容: //请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * //
 * // 实现词典类 WordDictionary ：
 * //
 * //
 * // WordDictionary() 初始化词典对象
 * // void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * // bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些
 * //'.' ，每个 . 都可以表示任何一个字母。
 * //
 * //
 * //
 * //
 * // 示例：
 * //
 * //
 * //输入：
 * //["WordDictionary","addWord","addWord","addWord","search","search","search",
 * //"search"]
 * //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * //输出：
 * //[null,null,null,null,false,true,true,true]
 * //
 * //解释：
 * //WordDictionary wordDictionary = new WordDictionary();
 * //wordDictionary.addWord("bad");
 * //wordDictionary.addWord("dad");
 * //wordDictionary.addWord("mad");
 * //wordDictionary.search("pad"); // return False
 * //wordDictionary.search("bad"); // return True
 * //wordDictionary.search(".ad"); // return True
 * //wordDictionary.search("b.."); // return True
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= word.length <= 500
 * // addWord 中的 word 由小写英文字母组成
 * // search 中的 word 由 '.' 或小写英文字母组成
 * // 最多调用 50000 次 addWord 和 search
 * //
 * // Related Topics 深度优先搜索 设计 字典树 字符串 👍 371 👎 0
 * <p>
 * 日期：2021-11-14 17:56:58
 */
//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 50000 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 371 👎 0

package leetcode.editor.cn;


import java.util.Map;
import java.util.TreeMap;

public class P211DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary solution = new P211DesignAddAndSearchWordsDataStructure().new WordDictionary();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        private class Node {
            // 是否是某个单词的末尾
            public boolean isWordTail;
            // trie 树的子节点
            public Map<Character, Node> next;

            public Node() {
                this(false);
            }

            public Node(boolean isWordTail) {
                this.isWordTail = isWordTail;
                next = new TreeMap<>();
            }
        }

        // trie树的根节点
        private Node root;
        // 代表有多少个单词
        private int size;

        public int getSize() {
            return size;
        }

        public WordDictionary() {
            root = new Node();
        }



        public void addWord(String word) {
            addWord(root, word, 0);
        }
        private void addWord(Node node, String word, int index) {
            if (index == word.length()) {
                if (!node.isWordTail) {
                    node.isWordTail = true;
                    size++;
                }
                return;
            }
            if (node.next.get(word.charAt(index)) != null) {
                addWord(node.next.get(word.charAt(index)), word, index + 1);
            } else {
                Node newNode = new Node(false);
                node.next.put(word.charAt(index), newNode);
                addWord(newNode, word, index + 1);
            }
        }
        public boolean search(String word) {

            return search(root, word, 0);
        }

        private boolean search(Node node, String word, int index) {
            if (index >= word.length()) {
                return node.isWordTail;
            }
            char c = word.charAt(index);
            // . 代表下面的所有节点都符合要求
            if ('.' == c) {
                for (Node n : node.next.values()) {
                    if (search(n, word, index + 1)) {
                        return true;
                    }
                }
            } else if (node.next.get(word.charAt(index)) != null) {
                return search(node.next.get(word.charAt(index)), word, index + 1);
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}