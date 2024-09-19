package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树
 * 1. 前中后便利  是看头的位置  头结点在前就是谦虚便利
 * 前序: 头左右
 * 中序: 左头右
 * 后续: 左右头
 * ---
 *
 */
public class PrintBinaryTree {

    /**
     *  递归便利
     * @param head
     */
    public static void f(Node head){
        if(head == null) return;
        // println语句在这就是前序 head.v
        f(head.z);
        // 在这就是中序
        f(head.y);
        // 在这就是后续
    }

    /**
     * 压栈非递归前序便利
     * 1. 创建一个Stack栈 把头结点放进去
     * 2.while循环遍历栈 不为空时, pop出头结点
     * 3. 当左节点不为空  push压入左节点
     * 4. 有节点不为空 压入有节点
     * @param root
     */
    public static List<Integer> preStack(Node root){
        List<Integer> res = new ArrayList<>();
        if(root != null){
            Stack<Node> s = new Stack<>();
            s.push(root);
            while (!s.isEmpty()){
                root = s.pop();
                res.add(root.val);
                if(root.y != null) s.push(root.y);
                if(root.z != null) s.push(root.z);
            }
        }
        return res;
    }

    /**
     * 二叉树实现后续便利
     * 已经知道先序便利是头左右  转变成 头右左
     * @param root
     * @return
     */
    public static List<Integer> posPrint(Node root){
        List<Integer> res = new ArrayList<>();
        if(root != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()){
                root = s1.pop();
                s2.push(root);
                if(root.z != null) s1.push(root.z);
                if(root.y != null) s1.push(root.y);
            }
            while (!s2.isEmpty()){
                res.add(s2.pop().val);
            }
        }
        return res;
    }


    public static List<Integer> midPrint(Node root){
        List<Integer> res = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        while (root != null || !s.isEmpty()){
            while (root != null){
                s.push(root);
                root = root.z;
            }
            root = s.pop();
            res.add(root.val);
            root = root.y;
        }
        return res;
    }






}
