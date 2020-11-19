package com.baogex.algorithm.offer.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 * </p>
 * <p>
 * 使用一个栈来模拟压入弹出操作。每次入栈一个元素后，都要判断一下栈顶元素是不是当前出栈序列 popSequence 的第一个元素，
 * 如果是的话则执行出栈操作并将 popSequence 往后移一位，继续进行判断。
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-11-19
 */
public class StackOrder1119 {

	public static void main(String[] args) {
		judgmentStackOrder(Arrays.asList("1", "2", "3", "4", "5"), Arrays.asList("4", "3", "5", "1", "2"));
	}

	//例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1
	private static void judgmentStackOrder(List<String> inNumList, List<String> outNumList) {
		if (inNumList == null || outNumList == null || (inNumList.size() != outNumList.size())) {
			throw new RuntimeException("两栈长度不一致或者为空");
		}
		int inIndex = 0, outIndex = 0, maxIndex = inNumList.size();
		Stack<String> inStack = new Stack<>();
		do {
			if (inIndex == maxIndex) {
				break;
			}
			String curInNum = inNumList.get(inIndex);
			inStack.push(curInNum);
			if (curInNum.equals(outNumList.get(outIndex))) {
				do {
					if (!inStack.isEmpty()) {
						inStack.pop();
					} else {
						break;
					}
				} while (inStack.size() != 0 && inStack.peek().equals(outNumList.get(++outIndex)));
			}
		} while (inIndex++ < maxIndex);
		System.out.println("出栈是否是入栈的正确出栈顺序:" + (outIndex == --maxIndex ? "是" : "否"));
	}

}
