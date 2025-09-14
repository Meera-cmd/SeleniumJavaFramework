package com.ui.tests;

    public class RotateArrayBruteForce {
        // Rotates the array 'arr' to the right by 'k' positions using brute force.
// No 'for' loops are used; only 'while' loops.
        public static void rotateRightBrute(int[] arr, int k) {
// Handle null or empty arrays; nothing to do
            if (arr == null || arr.length == 0) {
                return;
            }

            int n = arr.length;

// Normalize k so we don't do unnecessary rotations
// This also handles negative k by converting it to an equivalent positive rotation
            k = ((k % n) + n) % n;

// If k is 0, array stays the same
            if (k == 0) {
                return;
            }

// Perform rotation by 1 step, k times (brute force)
            int times = 0;
            while (times < k) {
// Save the last element
                int last = arr[n - 1];

// Shift all elements one step to the right
                int i = n - 1;
                while (i > 0) {
                    arr[i] = arr[i - 1];
                    i = i - 1;
                }

// Put the saved last element at the beginning
                arr[0] = last;

// Count this rotation step
                times = times + 1;
            }
        }

        // Simple demo
        public static void main(String[] args) {
            int[] a = {1, 2, 3, 4, 5};
            rotateRightBrute(a, 2); // expected -> {4, 5, 1, 2, 3}

            int idx = 0;
            while (idx < a.length) {
                System.out.print(a[idx] + (idx == a.length - 1 ? "\n" : " "));
                idx = idx + 1;
            }
        }
    }

//    Explanation of all statements:
//
//    public class RotateArrayBruteForce { ... } defines a public class named RotateArrayBruteForce.
//    public static void rotateRightBrute(int[] arr, int k) declares a static method that rotates arr by k places to the right. Static allows calling without creating an instance.
//if (arr == null || arr.length == 0) { return; } guards against null or empty arrays; in such cases, there’s nothing to rotate, so we exit early.
//    int n = arr.length; stores the length of the array in n for reuse.
//            k = ((k % n) + n) % n; normalizes k to the range [0, n-1]:
//    k % n reduces large k to within array length (e.g., rotating by n is a no-op).
//    Adding n before the second % handles negative k (e.g., k = -1 becomes n-1).
//            if (k == 0) { return; } if effective rotation is zero, exit early.
//    int times = 0; initializes a counter to track how many 1-step rotations have been performed.
//while (times < k) { ... } repeats the 1-step rotation k times (the brute-force approach).
//    int last = arr[n - 1]; saves the current last element, which will move to the front after the shift.
//    int i = n - 1; initializes an index to point to the last position for shifting.
//while (i > 0) { arr[i] = arr[i - 1]; i = i - 1; } shifts each element one position to the right, from end to start, stopping before index 0 (since arr[0] will be set to last).
//    arr[0] = last; places the previously saved last element at the front.
//            times = times + 1; increments the count of completed 1-step rotations.
//    In main:
//    int[] a = {1, 2, 3, 4, 5}; creates a sample array.
//    rotateRightBrute(a, 2); rotates the array by 2 positions to the right.
//    The while loop prints the array contents in a single line separated by spaces.
//    Time and space complexity:
//
//    Time complexity: O(n * k), because we shift O(n) elements per 1-step rotation, repeated k times.
//    Space complexity: O(1), using only a few extra variables regardless of input size.
//    Notes:
//
//    To rotate left by K instead (brute force), repeat: save first element, shift left by one using a while loop, place saved element at the end, K times.
//    For production use, prefer an O(n) approach (reverse segments), but this brute-force method matches your request.

