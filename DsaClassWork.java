import java.util.Scanner;

public class DsaClassWork {

    public static int computeDepth(TreeNode current) {
        if (current == null) return 0;
        int leftDepth = computeDepth(current.leftNode);
        int rightDepth = computeDepth(current.rightNode);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int countElements(TreeNode current) {
        if (current == null) return 0;
        return 1 + countElements(current.leftNode) + countElements(current.rightNode);
    }

    public static boolean isPresent(TreeNode current, int target) {
        if (current == null) return false;
        if (current.value == target) return true;
        return isPresent(current.leftNode, target) || isPresent(current.rightNode, target);
    }

    public static int totalLeaves(TreeNode current) {
        if (current == null) return 0;
        if (current.leftNode == null && current.rightNode == null) return 1;
        return totalLeaves(current.leftNode) + totalLeaves(current.rightNode);
    }

    public static int aggregateValues(TreeNode current) {
        if (current == null) return 0;
        return current.value + aggregateValues(current.leftNode) + aggregateValues(current.rightNode);
    }

    public static void displaySpecificLevel(TreeNode current, int requiredLevel, int currLevel) {
        if (current == null) return;
        if (requiredLevel == currLevel) {
            System.out.print(current.value + " ");
        }
        displaySpecificLevel(current.leftNode, requiredLevel, currLevel + 1);
        displaySpecificLevel(current.rightNode, requiredLevel, currLevel + 1);
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(10);
        rootNode.leftNode = new TreeNode(25);
        rootNode.rightNode = new TreeNode(35);
        rootNode.leftNode.leftNode = new TreeNode(45);
        rootNode.leftNode.rightNode = new TreeNode(55);
        rootNode.rightNode.leftNode = new TreeNode(65);
        rootNode.rightNode.rightNode = new TreeNode(75);

        System.out.println("Tree Depth: " + computeDepth(rootNode));
        System.out.println("Total Nodes: " + countElements(rootNode));
        System.out.println("Is value 25 in tree? " + isPresent(rootNode, 25));
        System.out.println("Leaf Nodes Count: " + totalLeaves(rootNode));
        System.out.println("Sum of all elements: " + aggregateValues(rootNode));
        System.out.print("Elements at level 2: ");
        displaySpecificLevel(rootNode, 2, 0);
    }
}

class TreeNode {
    int value;
    TreeNode leftNode;
    TreeNode rightNode;

    TreeNode(int value) {
        this.value = value;
    }
}
