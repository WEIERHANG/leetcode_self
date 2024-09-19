package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class BinaryTreeTester {

    // 手动生成简单的递归版本
    public static List<Integer> recursivePreOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        preOrderHelper(root, res);
        return res;
    }

    private static void preOrderHelper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);  // 前序
        preOrderHelper(root.z, res);
        preOrderHelper(root.y, res);
    }

    public static List<Integer> recursiveInOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        inOrderHelper(root, res);
        return res;
    }

    private static void inOrderHelper(Node root, List<Integer> res) {
        if (root == null) return;
        inOrderHelper(root.z, res);
        res.add(root.val);  // 中序
        inOrderHelper(root.y, res);
    }

    public static List<Integer> recursivePostOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        postOrderHelper(root, res);
        return res;
    }

    private static void postOrderHelper(Node root, List<Integer> res) {
        if (root == null) return;
        postOrderHelper(root.z, res);
        postOrderHelper(root.y, res);
        res.add(root.val);  // 后序
    }

    // 随机生成二叉树
    public static Node generateRandomBinaryTree(int depth, int maxValue) {
        if (depth == 0 || Math.random() > 0.7) {
            return null;
        }
        Node root = new Node(new Random().nextInt(maxValue));
        root.z = generateRandomBinaryTree(depth - 1, maxValue);
        root.y = generateRandomBinaryTree(depth - 1, maxValue);
        return root;
    }

    // 测试用例生成和对比
    public static void main(String[] args) {
        int testTimes = 100000;  // 测试次数
        int maxDepth = 5;       // 树的最大深度
        int maxValue = 100;     // 节点最大值

        for (int i = 0; i < testTimes; i++) {
            Node root = generateRandomBinaryTree(maxDepth, maxValue);

            // 测试前序遍历
            List<Integer> recursivePre = recursivePreOrder(root);
            List<Integer> nonRecursivePre = PrintBinaryTree.preStack(root);
            if (!recursivePre.equals(nonRecursivePre)) {
                System.out.println("前序遍历不一致！");
                return;
            }

            // 测试中序遍历
            List<Integer> recursiveIn = recursiveInOrder(root);
            List<Integer> nonRecursiveIn = PrintBinaryTree.midPrint(root);
            if (!recursiveIn.equals(nonRecursiveIn)) {
                System.out.println("中序遍历不一致！");
                return;
            }

            // 测试后序遍历
            List<Integer> recursivePost = recursivePostOrder(root);
            List<Integer> nonRecursivePost = PrintBinaryTree.posPrint(root);
            if (!recursivePost.equals(nonRecursivePost)) {
                System.out.println("后序遍历不一致！");
                return;
            }
        }

        System.out.println("所有测试通过！");
    }

}


