package com.baogex.algorithm.offer.stack;

import java.util.Stack;

/**
 * <h1>实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。</h1>
 * <p>
 * 使用一个额外的 minStack，栈顶元素为当前栈中最小的值。
 * 在对栈进行 push 入栈和 pop 出栈操作时，同样需要对 minStack 进行入栈出栈操作，
 * 从而使 minStack 栈顶元素一直为当前栈中最小的值。在进行 push 操作时，
 * 需要比较入栈元素和当前栈中最小值，将值较小的元素 push 到 minStack 中
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-11-18
 */
public class StackMin {
	private final Stack<Integer> dataStack = new Stack<>();
	private final Stack<Integer> minStack = new Stack<>();


	public static void main(String[] args) {
		StackMin contentMin = new StackMin();
		contentMin.push(1);
		System.out.println("pop:" + contentMin.pop());

		contentMin.push(2);
		contentMin.push(-1);


		contentMin.push(1);
		contentMin.push(1111);
		contentMin.push(1111);


		System.out.println("top:" + contentMin.top());
		System.out.println("min:" + contentMin.min());
	}

	public void push(int value) {
		dataStack.push(value);
		minStack.push(minStack.isEmpty() ? value : Math.min(minStack.peek(), value));
	}

	public Integer top() {
		return dataStack.peek();
	}

	public Integer min() {
		return minStack.peek();
	}

	public Integer pop() {
		Integer pop = dataStack.pop();
		if (minStack.peek().equals(pop)) {
			minStack.pop();
		}
		return pop;
	}

}
