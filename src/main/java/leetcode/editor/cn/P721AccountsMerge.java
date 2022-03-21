/**
  * 题目Id：721
  * 题目：账户合并
  * 内容: //给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其
//余元素是 emails 表示该账户的邮箱地址。 
//
// 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为
//人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。 
//
// 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", 
//"johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], [
//"Mary", "mary@mail.com"]]
//输出：[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']
//,  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//解释：
//第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 
//第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
//可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
//['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的
//。
// 
//
// 示例 2： 
//
// 
//输入：accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin",
//"Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co",
//"Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.
//co","Fern1@m.co","Fern0@m.co"]]
//输出：[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co",
//"Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],[
//"Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.
//co","Fern5@m.co"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= accounts.length <= 1000 
// 2 <= accounts[i].length <= 10 
// 1 <= accounts[i][j].length <= 30 
// accounts[i][0] 由英文字母组成 
// accounts[i][j] (for j > 0) 是有效的邮箱地址 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 字符串 👍 346 👎 0
	
  * 日期：2022-03-12 18:23:15
*/
//给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其
//余元素是 emails 表示该账户的邮箱地址。 
//
// 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为
//人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。 
//
// 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", 
//"johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], [
//"Mary", "mary@mail.com"]]
//输出：[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']
//,  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//解释：
//第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 
//第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
//可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
//['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的
//。
// 
//
// 示例 2： 
//
// 
//输入：accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin",
//"Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co",
//"Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.
//co","Fern1@m.co","Fern0@m.co"]]
//输出：[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co",
//"Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],[
//"Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.
//co","Fern5@m.co"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= accounts.length <= 1000 
// 2 <= accounts[i].length <= 10 
// 1 <= accounts[i][j].length <= 30 
// accounts[i][0] 由英文字母组成 
// accounts[i][j] (for j > 0) 是有效的邮箱地址 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 字符串 👍 346 👎 0

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class P721AccountsMerge {
    public static void main(String[] args) {
        Solution solution = new P721AccountsMerge().new Solution();
        // [["David","David0@m.co","David4@m.co","David3@m.co"],["David","David5@m.co","David5@m.co","David0@m.co"],["David","David1@m.co","David4@m.co","David0@m.co"],
        // ["David","David0@m.co","David1@m.co","David3@m.co"],["David","David4@m.co","David1@m.co","David3@m.co"]]
        List<List<String>> data = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("David");
        t1.add("David0@m.co");
        t1.add("David4@m.co");
        t1.add("David3@m.co");
        data.add(t1);
        List<String> t2 = new ArrayList<>();
        t2.add("David");
        t2.add("David0@m.co");
        t2.add("David4@m.co");
        t2.add("David3@m.co");
        data.add(t2);
        /*List<String> t2 = new ArrayList<>();
        t2.add("David");
        t2.add("David5@m.co");
        t2.add("David5@m.co");
        t2.add("David0@m.co");
        data.add(t2);

        List<String> t3 = new ArrayList<>();
        t3.add("David");
        t3.add("David1@m.co");
        t3.add("David4@m.co");
        t3.add("David0@m.co");
        data.add(t3);

        List<String> t4 = new ArrayList<>();
        t4.add("David");
        t4.add("David0@m.co");
        t4.add("David1@m.co");
        t4.add("David3@m.co");
        data.add(t4);

        List<String> t5 = new ArrayList<>();
        t5.add("David");
        t5.add("David4@m.co");
        t5.add("David1@m.co");
        t5.add("David3@m.co");
        data.add(t5);*/

        List<List<String>> lists = solution.accountsMerge(data);



        System.out.println("Hello world" + lists);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        public class ValNode<V> {
            private V val;
            public ValNode(V val) {
                this.val = val;
            }
        }
        private Map<String, List<Integer>> emailMap = new HashMap<>();
        private Map<List<String>, ValNode<List<String>>> nodeMap = new HashMap<>();
        private Map<ValNode<List<String>>, ValNode<List<String>>> parents= new HashMap<>();

        private Map<ValNode<List<String>>, Set<String>> rootSizeMap= new HashMap<>();
        public List<List<String>> accountsMerge(List<List<String>> accounts) {

            int accountindex = 0;
            for (List<String> account : accounts) {
                ValNode<List<String>> valNode = new ValNode<List<String>>(account);
                nodeMap.put(account, valNode);
                parents.put(valNode, valNode);
                for (int i = 1; i < account.size();i++) {
                    if (emailMap.containsKey(account.get(i))) {
                        List<Integer> integers = emailMap.get(account.get(i));
                        integers.add(accountindex);
                        emailMap.put(account.get(i), integers);
                    } else {
                        List<Integer> init = new ArrayList<>();
                        init.add(accountindex);
                        emailMap.put(account.get(i), init);
                    }
                }
                accountindex++;
            }
            nodeMap.entrySet().stream().forEach(entry -> {
                rootSizeMap.put(entry.getValue(), new HashSet<>(entry.getKey().subList(1, entry.getKey().size())));
            });

            for (Map.Entry<String, List<Integer>> entry : emailMap.entrySet()) {
                List<Integer> emailEqualList = entry.getValue();
                for (int i = 0; i < emailEqualList.size() - 1; i++) {
                    for (int j = i + 1; j < emailEqualList.size(); j++) {
                        ValNode<List<String>> n1 = findFather(accounts.get(emailEqualList.get(i)));
                        ValNode<List<String>> n2 = findFather(accounts.get(emailEqualList.get(j)));
                        if (n1 != n2)  {
                            mergerUnion(n1, n2);
                        }
                    }
                }
            }
            // handle result
            List<List<String>> list = new ArrayList<>();
            for (Map.Entry<ValNode<List<String>>, Set<String>> entry : rootSizeMap.entrySet()) {
                List<String> result = new ArrayList<>();
                String name = entry.getKey().val.get(0);
                result.add(name);
                result.addAll(entry.getValue().stream().sorted().collect(Collectors.toList()));
                list.add(result);
            }
            return list;


        }

        private void mergerUnion(ValNode<List<String>> n1, ValNode<List<String>> n2) {
            Set<String> result1 = rootSizeMap.get(n1);
            Set<String> result2 = rootSizeMap.get(n2);
            ValNode<List<String>> big = result1.size() >= result2.size() ? n1 : n2;
            ValNode<List<String>> small = big == n1 ? n2 : n1;
            parents.put(small, big);
            result1.addAll(result2);
            rootSizeMap.put(big, result1);
            rootSizeMap.remove(small);
        }

        public ValNode<List<String>> findFather(List<String> l1) {
            ValNode<List<String>> n1 = nodeMap.get(l1);
            Stack<ValNode<List<String>>> stack = new Stack<>();
            stack.push(n1);
            ValNode<List<String>> cur = n1;
            while (parents.get(cur) != null && cur != parents.get(cur)) {
                ValNode<List<String>> temp = parents.get(cur);
                stack.push(temp);
                cur = temp;
            }
            while (!stack.isEmpty()) {
                parents.put(stack.pop(), cur);
            }
            return cur;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}