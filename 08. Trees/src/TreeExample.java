public class TreeExample {
	public static void main (String[] args) {
		TreeNode1 root = new TreeNode1(1);
		root.left = new TreeNode1(2);
		root.right = new TreeNode1(3);
		
		System.out.println("Root: "+ root.value);
		System.out.println("Left Child: " + root.left.value);
		System.out.println("Right Child: " + root.right.value);
	}
	
	public static void preorder(TreeNode1 node) {
		if (node == null) return;
		System.out.println(node.value + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public static int sum(TreeNode1 node) {
		if (node == null) return 0;
		return node.value + sum(node.left) + sum(node.right);	
	}
	
	public static int countLeaves(TreeNode1 node) {
		if (node == null) return 0;
		if (node.left == null && node.right == null) return 1;
		return countLeaves(node.left) + countLeaves(node.right);
	}
	
	public static int height(TreeNode1 node) {
		if (node == null) return 0;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
