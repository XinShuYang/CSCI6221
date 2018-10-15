package sort;
import quickSort.quickSort;
import sort.recursionsort;
public class rng {
	public static Integer[] randArr(){
		int minimum =0, maximum = 2000;
		Integer[] rand = new Integer[10];
		for(int j =0; j<10; j++) {
			int x = minimum + (int)(Math.random() * maximum);
			rand[j] = x;
			//System.out.println(x);
		}
		return rand;
	}

	public static void main(String[] args){
		
		quickSort s = new recursionsort();
		quickSort nonrecursion = new NonRecursion();
		Integer[] rand1 = randArr();
		Integer[] rand2 = randArr();
		System.out.println("before sort");
		for(int j =0; j<10; j++) {			
			System.out.println(rand1[j]);
		}
		
		s.sort(rand1);
		System.out.println("after sort - recursion version");
		for(int j =0; j<10; j++) {			
			System.out.println(rand1[j]);
		}
		
		System.out.println("before sort");
		for(int j =0; j<10; j++) {			
			System.out.println(rand2[j]);
		}
		nonrecursion.sort(rand2);
		System.out.println("non recursion version");
		for(int j =0; j<10; j++) {			
			System.out.println(rand2[j]);
		}
	}
}