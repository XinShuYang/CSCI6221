package sort;
import quickSort.quickSort;
import java.util.Random;
import java.util.Stack;
public class NonRecursion implements quickSort{
	public void sort(Integer[] input) {
		Stack<Integer> stack = new Stack();
		int i,j;
		stack.push(input.length - 1);
		stack.push(0);
		while(!stack.isEmpty()) {
			i = stack.pop();
			j = stack.pop();
			if(i < j) {
				int k = paritation(input, i, j);
				if(k > i) {
					stack.push(k - 1);
					stack.push(i);
				}
				if(k < j) {
					stack.push(j);
					stack.push(k + 1);
				}
			}
		}
	}
	
	private int paritation(Integer[] input, int left, int right) {
		int priot = input[left];
		int i = left, j = right;
		while(true) {
			while(input[++i] < priot) {
				if(i == right)
					break;
			}
			while(input[--j] > priot) {
				if(j == left)
					break;
			}
			if(i > j) {
				break;
			}
			swap(input, i, j);
		}
		swap(input, left, j);
		return j;
		
	}
	
	public void swap(Integer[] input, int aIndex, int bIndex) {
		if(aIndex == bIndex) {
			return;
		}
		int t = input[aIndex];
		input[aIndex] = input[bIndex];
		input[bIndex] = t;
	}

	public static void main(String[] args) {
		Integer[] arrs = new Integer[] {1,5,3,7,3,88,6,9,33,4,5,12,33,42};
		quickSort s = new NonRecursion();
		s.sort(arrs);
		for(int i = 0;i < arrs.length;i++) {
			System.out.println(arrs[i]);
		}
	}

}
