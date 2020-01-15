package c04_binary_tree;

import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.sun.security.auth.NTDomainPrincipal;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.omg.CORBA.NO_IMPLEMENT;
import sun.misc.Queue;

import javax.print.attribute.standard.NumberOfDocuments;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class BST<T extends Comparable<T>> {
    private Node root;
    private int size;
    public BST(){
        this.root = null;
        this.size = 0;
    }
    //insert (递归插入)
    public void insert(T key,Object value){
        this.root = insert(this.root,key,value);
    }
    private Node insert(Node node,T key,Object value){
        if (node == null){
            this.size ++;
            return new Node(key,value);
        }
        if (node.key.compareTo(key) > 0){
            node.left = insert(node.left,key,value);
            return node;
        }else if (node.key.compareTo(key) < 0){
            node.right = insert(node.right,key,value);
            return node;
        }else {
            node.value =value;
            return node;
        }
    }
    //insert (非递归插入)
    public void insertNR(T key,Object value){
        if (this.root == null){
            this.root = new Node(key,value);
        }else {
            Node node = this.root;
            Node pre = null;
            while (node != null){
                if (node.key.compareTo(key) == 0){
                    node.value = value;
                    pre = null;
                    break;
                }else if (node.key.compareTo(key) > 0){
                    node = node.left;
                }else {
                    node = node.right;
                }
                pre = node;
            }
            if (pre != null){
                this.size ++;
                if (pre.key.compareTo(key) > 0){
                    pre.left = new Node(key,value);
                }else {
                    pre.right = new Node(key,value);
                }
            }


        }
    }
    public int getSize(){
        return this.size;
    }
    //contains
    public boolean contains(T key){
        return contains(this.root,key);
    }
    private boolean contains(Node node,T key){
        if (node == null){
            return false;
        }
        if (node.key.compareTo(key) > 0){
            return contains(node.left,key);
        }else if (node.key.compareTo(key) < 0){
            return contains(node.right,key);
        }else {
            return true;
        }
    }
    //search
    public Object search(T key){
        Node node = search(this.root, key);
        if (node == null){
            return null;
        }else {
            return node.value;
        }
    }
    public Node search(Node node,T key){
        if (node == null){
            return null;
        }
        if (node.key.compareTo(key) == 0){
            return node;
        }else if (node.key.compareTo(key) < 0){
            return search(node.right,key);
        }else {
            return search(node.left,key);
        }
    }
    //preOrder
    public void preOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        preOrder(this.root, stringBuffer);
        System.out.println(stringBuffer.toString());
    }
    private void preOrder(Node node,StringBuffer stringBuffer){
        if (node != null){
            stringBuffer.append(node.value + ",");
            preOrder(node.left, stringBuffer);
            preOrder(node.right, stringBuffer);
        }
    }
    //inOrder
    public void inOrder(){
        inOrder(this.root);
    }
    private void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            System.out.print(node.value+" ");
            inOrder(node.right);
        }
    }
    //postOrder
    public void postOrder(){
        postOrder(this.root);
    }
    private void postOrder(Node node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value+" ");
        }
    }
    //preOrder的非递归实现，使用栈
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(this.root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            if (pop != null){
                System.out.print(pop.value+" ");
                stack.push(pop.right);
                stack.push(pop.left);
            }
        }

    }
    //层序遍历
    public void layerOrder(){
        Queue<Node> queue = new Queue<>();
        queue.enqueue(this.root);
        while (!queue.isEmpty()){
            try {
                Node node = queue.dequeue();
                if (node != null){
                    System.out.print(node.value+" ");
                    queue.enqueue(node.left);
                    queue.enqueue(node.right);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //找出最小值的节点
    public Node minimum(Node node){
        if (node == null){
            return null;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;

    }
    //找出最大值的节点
    public Node maximum(){
        if (this.root == null){
            return null;
        }
        return maximum(this.root);
    }
    private Node maximum(Node node){
        if (node.right == null){
            return node;
        }
        return maximum(node.right);
    }
    //删除最小值
    public Object removeMinimum(){
        Node minimum = minimum(this.root);
        if (minimum == null){
            return null;
        }
        this.root = removeMinimum(this.root);
        return minimum.value;
    }
    private Node removeMinimum(Node node){
        if (node.left != null){
            node.left = removeMinimum(node.left);
            return node;
        }else {
            this.size --;
            Node right = node.right;
            node.right = null;
            return right;
        }
    }
    //删除最大值
    public Object removeMaximum(){
        Node maximum = maximum();
        if (maximum == null){
            return null;
        }
        this.root = removeMaximum(this.root);
        return maximum.value;
    }
    private Node removeMaximum(Node node){
        if (node.right != null){
            node.right = removeMaximum(node.right);
            return node;
        }else {
            this.size --;
            Node left = node.left;
            node.left = null;
            return left;
        }
    }
    //删除任意一个节点
    public void remove(T key){
        this.root = remove(this.root,key);
    }
    private Node remove(Node node,T key){
        if (node == null){
            return null;
        }
        if (node.key.compareTo(key) > 0){
            node.left = remove(node.left,key);
            return node;
        }else if (node.key.compareTo(key) < 0){
            node.right = remove(node.right,key);
            return node;
        }else {
            if (node.left == null){
                Node right = node.right;
                node.right = null;
                this.size --;
                return right;
            }else if (node.right == null){
                Node left = node.left;
                node.left = null;
                this.size --;
                return left;
            }else {
                Node minimum = minimum(node.right);
                Node successor = new Node(minimum.key, minimum.value);
                successor.left = node.left;
                successor.right = removeMinimum(node.right);
                return successor;
            }
        }
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    private class Node{
        private T key;
        private Object value;
        private Node left;
        private Node right;

        public Node(T key,Object value){
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }
    public static void main(String[] args){
        BST<Integer> bst = new BST<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        Random random = new Random();
        Integer[] integers = {16, 46, 32, 34, 5, 7, 49, 30, 21, 28};
        for (int i = 0;i < 10;i++){
//            int nextInt = random.nextInt(50);
            bst.insert(integers[i],i);
//            list.add(nextInt);
        }
        System.out.println(integers);
//        System.out.println(list);
//        bst.inOrder();
//        System.out.println();
//        bst.preOrder();
//        bst.preOrderNR();
        bst.layerOrder();
    }
}
