package ir.ac.vru.tree;

import java.util.Vector;

public class BST extends BinaryTree {
    public BST() {
        super();
    }

    public void insert(BinaryNode newNode) {
        newNode.setLeft(null);
        newNode.setRight(null);
        newNode.setParent(null);

        if (root == null) {
            root = newNode;
            size++;
        } else {
            insert(root, newNode);
        }
    }

    protected void insert(BinaryNode node, BinaryNode newNode) {
        if (newNode.compareTo(node) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                newNode.setParent(node);
                size++;
            } else {
                insert(node.getLeft(), newNode);
            }
        } else if (newNode.compareTo(node) > 0) {
            if (node.getRight() == null) {
                node.setRight(newNode);
                newNode.setParent(node);
                size++;
            } else {
                insert(node.getRight(), newNode);
            }
        }
    }

    public void insert_iterative(BinaryNode newNode) {
        newNode.setLeft(null);
        newNode.setRight(null);
        newNode.setParent(null);

        if (root == null) {
            root = newNode;
            size++;
        }
        else {
            BinaryNode node = root;
            while (true) {
                if (newNode.compareTo(node) < 0) {
                    // going left
                    if (node.getLeft() == null) {
                        node.setLeft(newNode);
                        newNode.setParent(node);
                        size++;
                        break;
                    }
                    else {
                        node = node.getLeft();
                    }
                }
                else if (newNode.compareTo(node) > 0) {
                    // going right
                    if (node.getRight() == null) {
                        node.setRight(newNode);
                        newNode.setParent(node);
                        size++;
                        break;
                    }
                    else {
                        node = node.getRight();
                    }
                }
                else {
                    // we found it, so no need to insert it
                    break;
                }
            }
        }
    }

    public BinaryNode find(BinaryNode findNode) {
        if (findNode == null) {
            return null;
        }
        else {
            return find(root, findNode);
        }
    }

    protected BinaryNode find(BinaryNode node, BinaryNode findNode) {
        if (node == null) {
            return null;
        }
        else if (node.compareTo(findNode) == 0) {
            // we found it
            return node;
        }
        else if (node.compareTo(findNode) > 0) {
            return find(node.getLeft(), findNode);
        }
        else {
            return find(node.getRight(), findNode);
        }
    }

    public BinaryNode find_iterative(BinaryNode findNode) {
        throw new UnsupportedOperationException("Not supported yet.");
        // TODO: implement this method
    }

    public BinaryNode findMin() {
        return findMin(root);
    }

    protected BinaryNode findMin_iterative(BinaryNode node) {
        if (node == null) {
            return null;
        }
        else {
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
            return node;
        }
    }

    protected BinaryNode findMin(BinaryNode node) {
        if (node == null) {
            return null;
        }
        else if (node.getLeft() == null) {
            return node;
        }
        else {
            return findMin(node.getLeft());
        }
    }

    public BinaryNode findMax() {
        throw new UnsupportedOperationException("Not supported yet.");
        // TODO: implement this method
    }

    protected BinaryNode findMax_iterative(BinaryNode node) {
        throw new UnsupportedOperationException("Not supported yet.");
        // TODO: implement this method
    }

    protected BinaryNode findMax(BinaryNode node) {
        throw new UnsupportedOperationException("Not supported yet.");
        // TODO: implement this method
    }

    public void delete(BinaryNode node) throws IllegalStateException{
        // find the node to delete
        BinaryNode deleteNode = find(node);
        if (deleteNode == null) {
            throw new IllegalStateException("Node not found");
        }
        // if the node has no children
        if (deleteNode.getLeft() == null && deleteNode.getRight() == null) {
            // if the node is the root
            if (deleteNode == root) {
                root = null;
            }
            // if the node is the left child of its parent
            else if (deleteNode.getParent().getLeft() == deleteNode) {
                deleteNode.getParent().setLeft(null);
            }
            // if the node is the right child of its parent
            else {
                deleteNode.getParent().setRight(null);
            }
        }
        // if the node has one child
        else if (deleteNode.getLeft() == null || deleteNode.getRight() == null) {
            // if the node is the root
            if (deleteNode == root) {
                if (deleteNode.getLeft() == null) {
                    root = deleteNode.getRight();
                    root.setParent(null);
                }
                else {
                    root = deleteNode.getLeft();
                    root.setParent(null);
                }
            }
            // if the node is the left child of its parent
            else if (deleteNode.getParent().getLeft() == deleteNode) {
                if (deleteNode.getLeft() == null) {
                    deleteNode.getParent().setLeft(deleteNode.getRight());
                    deleteNode.getRight().setParent(deleteNode.getParent());
                }
                else {
                    deleteNode.getParent().setLeft(deleteNode.getLeft());
                    deleteNode.getLeft().setParent(deleteNode.getParent());
                }
            }
            // if the node is the right child of its parent
            else {
                if (deleteNode.getLeft() == null) {
                    deleteNode.getParent().setRight(deleteNode.getRight());
                    deleteNode.getRight().setParent(deleteNode.getParent());
                }
                else {
                    deleteNode.getParent().setRight(deleteNode.getLeft());
                    deleteNode.getLeft().setParent(deleteNode.getParent());
                }
            }
        }
        // if the node has two children
        else {
            // find the inorder successor
            BinaryNode successor = findMin(deleteNode.getRight());
            delete(successor);
            // replace the node to be deleted with the successor
            successor.setLeft(deleteNode.getLeft());
            successor.setRight(deleteNode.getRight());
            if (deleteNode == root) {
                root = successor;
                successor.setParent(null);
            }
            else if (deleteNode.getParent().getLeft() == deleteNode) {
                deleteNode.getParent().setLeft(successor);
                successor.setParent(deleteNode.getParent());
            }
            else {
                deleteNode.getParent().setRight(successor);
                successor.setParent(deleteNode.getParent());
            }
        }
        // decrement the size
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        // get all the nodes and delete them
        for (BinaryNode node : depth_first_iterative()) {
            delete(node);
        }
        /*
        root = null;
        size = 0;
        */
    }

    public Vector<BinaryNode> sort() {
        return inorder_iterative();
    }

}
