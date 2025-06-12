import java.util.Iterator;

public class GeneralTreeExample {
	    public static void main(String[] args) {

	    	        TreeNode root = new TreeNode(1);
	    	        TreeNode node2 = new TreeNode(2);
	    	        TreeNode node3 = new TreeNode(3);
	    	        TreeNode node4 = new TreeNode(4);

	    	        root.children.add(node2);
	    	        root.children.add(node3);
	    	        root.children.add(node4);

	    	        printTree(root, 0);

	    	        System.out.println("\n--- 3'ün Altına 5 Ekle ---");
	    	        addNode(root, 3, 5);
	    	        printTree(root, 0);

	    	        System.out.println("\n--- 3'ü Sil ---");
	    	        deleteNode(root, 3);
	    	        printTree(root, 0);
	    	    }
	
	public static void printTree(TreeNode node, int level) {
		if (node == null) return;
		System.out.println("  ".repeat(level) + "- " + node.value);
		for (TreeNode child : node.children) {
			printTree(child, level + 1);
		}
	}
	
	public static int sum(TreeNode node) {
		if(node == null) return 0;
		
		int total = node.value;
		for (TreeNode child : node.children) {
			total += sum(child);
		}
		return total;
	}
	
	public static int countLeaves(TreeNode node) {
		if (node == null) return 0;
		if (node.children.isEmpty()) return 1;
		
		int total = 0;
		for (TreeNode child: node.children) {
			total += countLeaves(child);
		}
		return total;
	}
	
	public static int height(TreeNode node) {
	    if (node == null) return 0;
	    if (node.children.isEmpty()) return 1;

	    int maxChildHeight = 0;
	    for (TreeNode child : node.children) {
	        maxChildHeight = Math.max(maxChildHeight, height(child));
	    }
	    return maxChildHeight + 1;
	}
	
	public static boolean contains(TreeNode node, int target) {
	    if (node == null) return false;
	    if (node.value == target) return true;

	    for (TreeNode child : node.children) {
	        if (contains(child, target)) return true;
	    }
	    return false;
	}
	public static boolean addNode(TreeNode node, int parentValue, int newValue) {
		if (node == null) return false;
		
		if (node.value == parentValue) {
			node.children.add(new TreeNode(newValue));
			return true;
		}
		
		for(TreeNode child : node.children) {
			if (addNode(child, parentValue, newValue)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean deleteNode(TreeNode node, int valueToDelete) {
		if (node == null) return false;
		
		Iterator<TreeNode> iterator = node.children.iterator();
		while (iterator.hasNext()) {
			TreeNode child = iterator.next();
			if (child.value == valueToDelete) {
				iterator.remove();
				return true;
			} else {
				if (deleteNode(child, valueToDelete)) return true;
			}
		}
		return false;
	}

}













