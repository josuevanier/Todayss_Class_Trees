package org.example;


import java.util.ArrayList;
import java.util.List;

class Node {
        //sirt
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
public class BinarySearchTree {

    public static Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean find(int id) {
        Node current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            //now we have found the minimum element in the right sub tree
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    // Other methods...

    // In-order traversal
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // Pre-order traversal
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // Post-order traversal
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    public Node findParent(Node node, int id) {
        if (node == null || node.data == id) {
            return null; // No parent found or target node is root
        }
        if ((node.left != null && node.left.data == id) || (node.right != null && node.right.data == id)) {
            return node; // Parent of the target node
        }
        Node leftParent = findParent(node.left, id);
        if (leftParent != null) {
            return leftParent;
        }
        return findParent(node.right, id);
    }
    // Method to find all cousins of a node
    public List<Integer> findCousins(int data) {
        List<Integer> cousins = new ArrayList<>();
        int level = findLevel(root, data, 1);
        if (level <= 1) {
            // Node is either root or does not exist
            return cousins;
        }
        Node parent = findParent(root, data);
        if (parent == null) {
            // Node is root or not found, no cousins
            return cousins;
        }
        for (int i = 1; i <= level - 1; i++) {
            findCousins(root, data, i, parent, cousins);
        }
        return cousins;
    }

    // Helper method to find cousins at a given level
    private void findCousins(Node node, int data, int level, Node parent, List<Integer> cousins) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            if (node != parent && (parent == null || node != parent.left && node != parent.right)) {
                cousins.add(node.data);
            }
        } else if (level > 1) {
            findCousins(node.left, data, level - 1, parent, cousins);
            findCousins(node.right, data, level - 1, parent, cousins);
        }
    }
    // Method to find the level of a node
    public int findLevel(Node node, int data, int level) {
        if (node == null) {
            return 0;
        }
        if (node.data == data) {
            return level;
        }
        int downLevel = findLevel(node.left, data, level + 1);
        if (downLevel != 0) {
            return downLevel;
        }
        downLevel = findLevel(node.right, data, level + 1);
        return downLevel;

    }
    public int findDepth(Node node, int data, int depth) {
        if (node == null) {
            return 0;
        }
        if (node.data == data) {
            return depth;
        }
        int leftDepth = findDepth(node.left, data, depth + 1);
        int rightDepth = findDepth(node.right, data, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    public int findHeight(Node node) {
        if (node == null) {
            return -1; // Height of empty tree is -1
        }
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public Node findCommonAncestor(int node1, int node2) {
        return findCommonAncestor(root, node1, node2);
    }

    private Node findCommonAncestor(Node node, int node1, int node2) {
        if (node == null) {
            return null;
        }
        if (node.data > node1 && node.data > node2) {
            return findCommonAncestor(node.left, node1, node2);
        } else if (node.data < node1 && node.data < node2) {
            return findCommonAncestor(node.right, node1, node2);
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal
        System.out.println("Inorder traversal:");
        tree.inOrderTraversal();
        System.out.println();

        // Print preorder traversal
        System.out.println("Preorder traversal:");
        tree.preOrderTraversal();
        System.out.println();

        // Print postorder traversal
        System.out.println("Postorder traversal:");
        tree.postOrderTraversal();
        System.out.println();

        // Find parent of a node
        int nodeId = 60; // Change this to test with different nodes
        Node parent = tree.findParent(tree.root, nodeId);
        System.out.println("Parent of node " + nodeId + ": " + (parent != null ? parent.data : "None"));

        // Find cousins of a node
        List<Integer> cousins = tree.findCousins(nodeId);
        System.out.println("Cousins of node " + nodeId + ": " + cousins);

        // Find level of a node
        int level = tree.findLevel(tree.root, nodeId, 1);
        System.out.println("Level of node " + nodeId + ": " + level);
    }
    }

