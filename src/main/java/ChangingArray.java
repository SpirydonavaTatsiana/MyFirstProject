package main.java;

public class ChangingArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.print("Измененный массив: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}