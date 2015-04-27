
public class BST {
	// Root of tree
		BSTNode root;
		
		// Constructor
		public BST() {
	        this.root = null;
		}
		
		// Function for printing representation of tree
		public void print(BSTNode node) {
			if (node != null) {
				String lc; String rc;
				if (node.leftChild != null) {
					lc = node.leftChild.data;
				}
				else {
					lc = "null";
				}
				if (node.rightChild != null) {
					rc = node.rightChild.data;
				}
				else {
					rc = "null";
				}
				System.out.println(node.data + " LC " + lc + " RC " + rc);
				print(node.leftChild);
				print(node.rightChild);
				
			}
		}
		
		// Wrapper function for print
		public void print() {
			print(root);
		}
		
		// Wrapper function for insert
		public boolean insert(String title) {
			return this.insert(title, root);
		}
		
		// Wrapper function for find
		public boolean find(String title) {
			return this.find(title, root);
		}
		
		// Wrapper function for remove
		public boolean remove(String title) {
			return this.remove(title, root);
		}
		
		// Inserts book title into appropriate space in tree
		// Args: title = book title, root = current tree node
		private boolean insert(String title, BSTNode root) {
	        
	        if (root == null) {
	            //why we have this.root instead of root? be careful with this
	           //in this case I dont want to assign any granparents or parents
	        	this.root = new BSTNode(title);
	        	insert_case1(this.root); 
	            return true;
	            //Left subtree for BST
	        } else if (title.compareTo(root.data) < 0) {
				//Theres still no grandparents in this case
	        	if (root.leftChild == null) {
					// Base case 
					root.leftChild = new BSTNode(title);
					//assign the parent at depth 1
					root.leftChild.parent = root;
					insert_case1(root.leftChild);
					return true;
				}
				else {
					// Recursive step
					return insert(title, root.leftChild);
				}
	        
			}
			//right subtree for BST
			else if (title.compareTo(root.data) > 0) {
				if (root.rightChild == null) {
					// Base case 
					root.rightChild = new BSTNode(title);
					root.rightChild.parent = root;
					insert_case1(root.rightChild);
					return true;
				}
				else {
					// Recursive step
					return insert(title, root.rightChild);
				}
				//case for duplicate keys
	        } else if (title.compareTo(root.data) == 0) {
	            //print to system error, or some other output stream, just not standard output stream.
	            System.err.println("We don't want duplicate key");
	            return false;
	        }
	        return false;
			
		}
		
		// Locates book title in tree; if title not in tree, returns false
		private boolean find(String title, BSTNode root) {
			if (root == null) {
				// Base case 
				return false;
			}
			if (root.data.equals(title)) {
				// Base case
				return true;
			}
			else if (title.compareTo(root.data) < 0) {
				return find(title, root.leftChild);
			}
			else {
				return find(title, root.rightChild);
			}
		}
		
		// Finds next-largest element of subtree
		// = leftmost child of root's right subtree
		public BSTNode findMin(BSTNode root) {
			BSTNode currentNode = root;
			while (currentNode.leftChild != null){
				currentNode = currentNode.leftChild;
			}
			return currentNode;
		}
		
		// Replaces one node in tree with another
		// Args: root = node to be replaced, other = replacing node
		public void replaceNodeInParent(BSTNode root, BSTNode other) {
			if (root.parent != null) {
				if (root.equals(root.parent.leftChild)) {
					root.parent.leftChild = other;
				}
				else {
					root.parent.rightChild = other;
				}
			}
			if (other != null) {
				other.parent = root.parent;
			}
		}
		
		// Removes book title from tree
		// If book not in tree, returns 0
		// Args: title = book title, root = current node
		private boolean remove(String title, BSTNode root) {
			
			// Base case - not in tree
			if (root == null) {
				return false;
			}
			
			// Recursive step
			if (title.compareTo(root.data) < 0) {
				return remove(title, root.leftChild);
			}
			
			// Recursive step
			else if (title.compareTo(root.data) > 0) {
				return remove(title, root.rightChild);
			}
			
			// Base case - found title
			else {
				
				// Case 1 : node has two children
				// Replace node with successor; remove successor
				if (root.leftChild != null && root.rightChild != null) {
					BSTNode successor = findMin(root.rightChild);
					root.data = successor.data;
					return remove(successor.data, successor);  //This must return true, why? make sure you understand statement. Can we make it simple?
				}
				
				// Case 2 : node has one child
				// Replace node with child
				else if (root.leftChild != null) {
					replaceNodeInParent(root, root.leftChild);
	                return true;
				}
				
				else if (root.rightChild != null) {
					replaceNodeInParent(root, root.rightChild);
	                return true;
				}
				
				// Case 3 : node has no children
				// Replace node with null 
				else {
					replaceNodeInParent(root, null);
	                return true;
				}
			
			}
	  
		}
		//P is the parameter node
		public boolean rotateLeft(BSTNode node){
			//Let Q be P's right child
			BSTNode rightchild = new BSTNode(node.rightChild.data);
			//Set P's right child to be Q's left
			node.rightChild = rightchild.leftChild;
			//set Q's left child to be P
			rightchild.leftChild = node;
			return true;
			
			
		}
		//P is the passed node
		public void rotateRight(BSTNode node){
			//Let Q be P's left child
			BSTNode leftchild = new BSTNode(node.leftChild.data);
			//Set Qs left child to be P's right child
			leftchild.leftChild = node.rightChild;
			//Set P's right child to be Q
			node.rightChild = leftchild;
			
			
		}
		public void balance(BSTNode node){
			//considering two cases where we 1. perform a right rotation then left
			// 2. perform a left rotation then right
			
			
			
			
			
		}
		
		public void insert_case1(BSTNode node){
		//if this is the root node, color it black
		if (node.parent == null)
			node.color = "BLACK";
		else{
			insert_case2(node);
		}
		}

		public void insert_case2(BSTNode node) {
			if (node.parent.color == "BLACK")
				return;
			else
				insert_case3(node);
			
		}

		public void insert_case3(BSTNode node) {
			BSTNode u = node.getUncle();
			if (u != null && u.color == "RED"){
				node.parent.color = "BLACK";
				u.color = "BLACK";
				BSTNode g = node.parent.parent;
				g.color = "RED";
				insert_case1(g);
			}else{
				insert_case4(node);
			}
			
		}

		public void insert_case4(BSTNode node) {
			BSTNode g = node.parent.getParent();
			if ((node == node.parent.rightChild) && (node.parent == g.leftChild)){
				rotateLeft(node.parent);
				node = node.getLeftChild();
			}
			else if ((node == node.parent.leftChild)&&(node.parent == g.rightChild)){
					rotateRight(node.parent);
					node = node.getRightChild();
			}
			insert_case5(node);
			
		}

		public void insert_case5(BSTNode node) {
			BSTNode g = node.parent.getParent();
			
			node.parent.color = "BLACK";
			g.color = "RED";
			if (node == node.parent.getLeftChild())
				rotateRight(g);
			else
				rotateLeft(g);
			
		}
		
	}
	
	

