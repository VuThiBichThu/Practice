package exercise;

import java.util.ArrayList;
import java.util.List;

public class Ex {
	public static void main(String[] args) {
		System.out.print("Kiem tra so doi xung: ");
		System.out.println(isSnymmetryNumber(9));
		System.out.print("Kiem tra so hanh phuc: ");
		System.out.println(isHappyNumber(44));
		System.out.println("Xoay array:");
		int[] array = { 1, 2, 0, 7 };
		rotateArray(array, 1);
		rotateArray(array, 2);
		rotateArray(array, 3);

	}

	public static boolean isSnymmetryNumber(int n) {
		int tmp = n;
		String s = "";
		do {
			s += tmp % 10;
			tmp /= 10;
		} while (tmp > 0);
		return s.equals(String.valueOf(n));
	}

	public static boolean isHappyNumber(int n) {
		if (n < 1) {
			return false;
		}
		List<Integer> numbers = new ArrayList<>();
		while (n != sumOfSquareNumbers(n)) {
			numbers.add(n);
			n = sumOfSquareNumbers(n);
			if (numbers.contains(n)) {
				return false;
			}
		}
		return true;

	}

	public static int sumOfSquareNumbers(int n) {
		int sum = 0;
		do {
			sum += (n % 10) * (n % 10);
			n /= 10;
		} while (n > 0);
		return sum;
	}

	public static void rotateArray(int[] array, int step) {
		int n = array.length;
		int[] rotatedArray = new int[n];
		int i = 0, j = 0;
		int tmp = n - step;
		while (true) {
			if (tmp < n) {
				rotatedArray[i++] = array[tmp++];
			} else {
				rotatedArray[i++] = array[j++];
				if (j == (n - step)) {
					break;
				}
			}
		}
		System.out.println("Xoay buoc " + step);
		for (int index = 0; index < rotatedArray.length; index++) {
			System.out.print(rotatedArray[index] + " ");
		}
		System.out.println();
	}
}
