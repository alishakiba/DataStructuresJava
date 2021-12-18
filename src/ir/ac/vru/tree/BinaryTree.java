package ir.ac.vru.tree;

import ir.ac.vru.list.SinglyLLQueue;
import ir.ac.vru.list.Stack;

import java.util.Vector;

public class BinaryTree {
    protected BinaryNode root;
    protected int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    public Vector<BinaryNode> inorder_recursive() {
        Vector<BinaryNode> nodes = new Vector<BinaryNode>();
        inorder_recursive(root, nodes);
        return nodes;
    }

    protected void inorder_recursive(BinaryNode node, Vector<BinaryNode> nodes) {
        if (node == null)
            return;

        inorder_recursive(node.left, nodes);
        nodes.add(node);
        inorder_recursive(node.right, nodes);
    }

    public Vector<BinaryNode> preorder_recursive() {
        Vector<BinaryNode> nodes = new Vector<BinaryNode>();
        preorder_recursive(root, nodes);
        return nodes;
    }

    protected void preorder_recursive(BinaryNode node, Vector<BinaryNode> nodes) {
        if (node == null)
            return;

        nodes.add(node);
        preorder_recursive(node.left, nodes);
        preorder_recursive(node.right, nodes);
    }

    public Vector<BinaryNode> postorder_recursive() {
        Vector<BinaryNode> nodes = new Vector<BinaryNode>();
        postorder_recursive(root, nodes);
        return nodes;
    }

    protected void postorder_recursive(BinaryNode node, Vector<BinaryNode> nodes) {
        if (node == null)
            return;

        postorder_recursive(node.left, nodes);
        postorder_recursive(node.right, nodes);
        nodes.add(node);
    }

    public Vector<BinaryNode> inorder_iterative() {
        Vector<BinaryNode> nodes = new Vector<BinaryNode>();
        BinaryNode node = root;
        while (node != null) {
            if (node.left == null) {
                nodes.add(node);
                node = node.right;
            } else {
                BinaryNode temp = node.left;
                while (temp.right != null && temp.right != node)
                    temp = temp.right;
                if (temp.right == null) {
                    temp.right = node;
                    node = node.left;
                } else {
                    temp.right = null;
                    nodes.add(node);
                    node = node.right;
                }
            }
        }
        return nodes;
    }

    public Vector<BinaryNode> preorder_iterative() {
        Vector<BinaryNode> nodes = new Vector<BinaryNode>();
        BinaryNode node = root;
        while (node != null) {
            nodes.add(node);
            if (node.right == null)
                node = node.left;
            else
                node = node.right;
        }
        return nodes;
    }

    public Vector<BinaryNode> postorder_iterative() {
        Vector<BinaryNode> nodes = new Vector<BinaryNode>();
        BinaryNode node = root;
        BinaryNode prev = null;
        while (node != null) {
            if (node.right == null) {
                nodes.add(node);
                node = node.left;
            } else {
                prev = node.right;
                while (prev.left != null && prev.left != node)
                    prev = prev.left;
                if (prev.left == null) {
                    prev.left = node;
                    node = node.right;
                } else {
                    prev.left = null;
                    nodes.add(node);
                    node = node.left;
                }
            }
        }
        return nodes;
    }

    public Vector<BinaryNode> depth_first_recursive() {
        Vector<BinaryNode> nodes = new Vector<BinaryNode>();
        depth_first_recursive(root, nodes);
        return nodes;
    }

    protected void depth_first_recursive(BinaryNode node, Vector<BinaryNode> nodes) {
        if (node == null)
            return;

        nodes.add(node);
        depth_first_recursive(node.left, nodes);
        depth_first_recursive(node.right, nodes);
    }

    public Vector<BinaryNode> depth_first_iterative() {
        Vector<BinaryNode> nodes = new Vector<BinaryNode>();
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryNode node = stack.pop();
            nodes.add(node);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return nodes;
    }

    public Vector<BinaryNode> breadth_first_iterative() {
        Vector<BinaryNode> nodes = new Vector<BinaryNode>();
        SinglyLLQueue<BinaryNode> queue = new SinglyLLQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.dequeue();
            nodes.add(node);
            if (node.left != null)
                queue.enqueue(node.left);
            if (node.right != null)
                queue.enqueue(node.right);
        }
        return nodes;
    }

    public Vector<BinaryNode> breadth_first_recursive() {
        Vector<BinaryNode> nodes = new Vector<BinaryNode>();
        breadth_first_recursive(root, nodes);
        return nodes;
    }

    protected void breadth_first_recursive(BinaryNode node, Vector<BinaryNode> nodes) {
        if (node == null)
            return;

        SinglyLLQueue<BinaryNode> queue = new SinglyLLQueue<>();
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            BinaryNode temp = queue.dequeue();
            nodes.add(temp);
            if (temp.left != null)
                queue.enqueue(temp.left);
            if (temp.right != null)
                queue.enqueue(temp.right);
        }
    }
}
