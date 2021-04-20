package SumsOfDigitalFactorials;
/**
 * This is my for the Project Euler #254: Sums of Digit Factorials problem.
 * @author Marius Haueis
 * @version 20.04.2021
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class SumsOfDigitalFactorials {
	static long y = 0;
	static ArrayList<Integer> result;
	public static void main(String[] args) {
		result = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int queries = scan.nextInt();
		for (int i = 0; i < queries; i++) {
			long z = scan.nextLong();
			y = scan.nextLong();
			result.add((int) resultTwo(z%y));
		}
		for(int i = 0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}	
		scan.close();
	}

	private static long fnHelperFinal(long n) {
		LinkedList<Long> stack = new LinkedList<Long>();
		LinkedList<Long> resultList = new LinkedList<Long>();
		long result = 1;
		long ma = 0;
		long size = 0;
		long size1 = 0;
		while (n > 0) {
			stack.add(n % 10);
			n = n / 10;
		}
		size1 = stack.size();
		for (int i = 0; i < size1; i++) {
			long m = stack.remove(0);
			for (int b = 0; b < m; b++) {
				result *= (m - b);
			}
			resultList.add(result);
			result = 1;
		}
		long result1 = resultList.stream().reduce((long) 0, Long::sum);
		stack.clear();
		while (result1 > 0) {
			stack.add(result1 % 10);
			result1 = result1 / 10;
		}
		size = stack.size();
		for (int i = 0; i < size; i++) {
			ma += stack.remove(0);
		}
		return ma;
	}

	private static long giHelper(long n) {
		long b = 0;
		long recursion = 1;
		while (n != b) {
			b = fnHelperFinal(recursion);
			recursion++;
		}
		return recursion - 1;
	}

	private static long sgiHelper(long n) {
		LinkedList<Long> stack = new LinkedList<Long>();
		long m = 0;
		long result = 0;
		while (n > 0) {
			stack.add(n % 10);
			n = n / 10;
		}
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			m += stack.remove(0);
		}
		return m;
	}

	private static long resultTwo(long n) {
		long result = 0;
		for (int i = 0; i < n; i++) {
			result += sgiHelper(giHelper(n - i));
		}
		return result;
	}
}
