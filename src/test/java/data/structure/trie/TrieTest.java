package data.structure.trie;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void testMethod () {
        Trie trie = new Trie();

        trie.insert("apple");

        System.out.println(trie.getSize());

        boolean apple = trie.search("apple");

        System.out.println(apple);

        apple = trie.search("app");
        System.out.println(apple);

        boolean app = trie.startsWith("app");

        System.out.println("startswith app ? " + app);

        trie.insert("app");
        boolean app1 = trie.search("app");
        System.out.println("search app " + app1);
    }

}