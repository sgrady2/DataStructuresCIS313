//be lazy here, make everything protected
public class BSTNode {

	String data;	// book title
	BSTNode leftChild;	// left tree
	BSTNode rightChild;	// right tree
	BSTNode parent;		// parent node
	String color;
	// Constructor
	public BSTNode(String data) {
		this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
        this.color = "RED";
        
        //settings the nodes color as a boolean value
        //true or false means red and black respectively
        //RED==False Black==True
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public BSTNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}
	public BSTNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BSTNode rightChild) {
		this.rightChild = rightChild;
	}
	public BSTNode getParent() {
		return parent;
	}
	public void setParent(BSTNode parent) {
		this.parent = parent;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public BSTNode getUncle(){
		return this.parent.getParent();
	}
	

}

