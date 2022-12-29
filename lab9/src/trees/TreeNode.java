
package trees;

import java.util.*;

class TreeNode {
	private String name;
	private TreeNode parent;
	private ArrayList<TreeNode> children;

	TreeNode(String name) {
		this.name = name;
		children = new ArrayList<>();
	}

	String getName() {
		return name;
	}

	void addChild(TreeNode childNode) {
		this.children.add(childNode);
		childNode.parent = this;
	}

	// Searches subtree at this node for a node
	// with the given name. Returns the node, or null if not found.
	TreeNode getNodeWithName(String targetName) {
		// Does this node have the target name?
		if (this.name.equals(targetName)) {
			return this;
		}

		// No, recurse. Check all children of this node.
		for (TreeNode child : children) {
			// If child.getNodeWithName(targetName) returns a non-null node,
			// then that's the node we're looking for. Return it.
			TreeNode temp = child.getNodeWithName(targetName);
			if (temp != null) {
				return temp;
			}
		}

		// Not found anywhere.
		return null;
	}

	// Returns a list of ancestors of this TreeNode, starting with this node’s
	// parent and
	// ending with the root. Order is from recent to ancient.
	ArrayList<TreeNode> collectAncestorsToList() {
		ArrayList<TreeNode> ancestors = new ArrayList<>();
		TreeNode parent1 = this.parent;
		while (parent1 != null) {
			ancestors.add(parent1);
			parent1 = parent1.parent;
		}

		return ancestors;
	}

	public String toString() {
		return toStringWithIndent("");
	}

	private String toStringWithIndent(String indent) {
		String s = indent + name + "\n";
		indent += "  ";
		for (TreeNode childNode : children)
			s += childNode.toStringWithIndent(indent);
		return s;
	}
}
