package com.tree;

import java.util.Scanner;

public class Tree {
	
	static Scanner sc=null;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		
		Node root= createTree();
	    inOrder(root);
	    System.out.println();
	    preOrder(root);
	    System.out.println();
	    postOrder(root);
	    System.out.println();
	    System.out.println("height: "+height(root));
	    System.out.println();
	    System.out.println("size: "+ size(root));
	    System.out.println();
	    System.out.println("maximum: "+ maximum(root));
	    System.out.println();
	    System.out.println("minimum: "+ minimum(root));

	}
	
	static Node createTree() {
		Node root=null;
		System.out.println("Enter data: ");
		int data=sc.nextInt();
		
		if(data == -1) return null;
		root= new Node(data);
		
		System.out.println("Enter left for "+data);
		root.left= createTree();
		
		System.out.println("Enter right for "+data);
		root.right= createTree();
		
		return root;
	}
	
	static void inOrder(Node root) {
		if (root==null) return ;
		inOrder(root.left);
		System.out.print(root.data+ " ");
		inOrder(root.right);
	}
	static void preOrder(Node root) {
		if (root==null) return ;
		System.out.print(root.data+ " ");
		preOrder(root.left);
		
		preOrder(root.right);
	}
	static void postOrder(Node root) {
		if (root==null) return ;
		postOrder(root.left);
		
		postOrder(root.right);
		System.out.print(root.data+ " ");
	}
	static int height(Node root) {
		if (root==null) return 0;
		return Math.max(height(root.left), height(root.right))+1;
	}
	static int size(Node root) {
		if(root== null) return 0;
		return size(root.left)+size(root.right)+1;
	}
	static int maximum(Node root) {
		if (root == null) return Integer.MIN_VALUE;
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	}
	static int minimum(Node root) {
		if (root == null) return Integer.MAX_VALUE;
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}
}

class Node {
	Node left, right;
	int data;
	
	public Node(int data) {
		this.data=data;
	}
}
