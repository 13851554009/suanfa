package guangdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Solution {
//    Map<String, Integer> wordId = new HashMap<String, Integer>();
//    List<List<Integer>> edge = new ArrayList<List<Integer>>();
//    int nodeNum = 0;
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        for (String word : wordList) {
//            addEdge(word);
//        }
//        addEdge(beginWord);
//        if (!wordId.containsKey(endWord)) {
//            return 0;
//        }
//        int[] dis = new int[nodeNum];
//        Arrays.fill(dis, Integer.MAX_VALUE);
//        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
//        dis[beginId] = 0;
//
//        Queue<Integer> que = new LinkedList<Integer>();
//        que.offer(beginId);
//        while (!que.isEmpty()) {
//            int x = que.poll();
//            if (x == endId) {
//                return dis[endId] / 2 + 1;
//            }
//            for (int it : edge.get(x)) {
//                if (dis[it] == Integer.MAX_VALUE) {
//                    dis[it] = dis[x] + 1;
//                    que.offer(it);
//                }
//            }
//        }
//        return 0;
//    }
//
//    public void addEdge(String word) {
//        addWord(word);
//        int id1 = wordId.get(word);
//        char[] array = word.toCharArray();
//        int length = array.length;
//        for (int i = 0; i < length; ++i) {
//            char tmp = array[i];
//            array[i] = '*';
//            String newWord = new String(array);  // 创建虚拟节点 *it、h*t、hi* ……
//            addWord(newWord);
//            int id2 = wordId.get(newWord);
//            edge.get(id1).add(id2);     // 将虚拟节点的 id 与 原节点关联
//            edge.get(id2).add(id1);     // 反向关联
//            array[i] = tmp;     // 复位
//        }
//    }
//
//    /**
//     * word放入map，key = word, value = nodeNum++ (给每个单词一个编号)
//     * @param word
//     */
//    public void addWord(String word) {
//        if (!wordId.containsKey(word)) {
//            wordId.put(word, nodeNum++);
//            edge.add(new ArrayList<Integer>());
//        }
//    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        nodeToStack(l1, stack1);
        nodeToStack(l2, stack2);

        Stack<Integer> resultStack = new Stack();
        int num1 = 0;
        int num2 = 0;
        int up = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                num1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                num2 = stack2.pop();
            }
            int sum = num1 + num2 + up;
            resultStack.push(sum % 10);
            up = sum / 10;
            num1 = 0;
            num2 = 0;
        }

        if (up != 0) {
            resultStack.push(up);
        }

        while (!resultStack.isEmpty()) {
            resultNode = ss(resultNode, resultStack.pop());
        }
        return resultNode;
    }

    private void nodeToStack(ListNode node, Stack stack) {
        ListNode current = node;
        while (current != null) {
            stack.push(current.val());
            current = current.next();
        }
    }

    public ListNode ss(ListNode node, int val) {
        ListNode parent = new ListNode(val);
        if (node != null) {
            parent.setNext(node);
        }
        return parent;
    }

}
