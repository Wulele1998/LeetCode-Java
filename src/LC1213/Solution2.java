package LC1213;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        // three pointers
        // N: the minimum length of three arrays
        // time: O(N)
        // space: O(1)
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                res.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                if (arr1[i] > arr2[j]) {
                    j++;
                    if (arr1[i] > arr3[k]) {
                        k++;
                    } else if (arr1[i] < arr3[k]) {
                        i++;
                    }
                } else if (arr1[i] == arr2[j]) {
                    if (arr1[i] < arr3[k]) {
                        i++;
                        j++;
                    } else {
                        k++;
                    }
                } else {
                    // arr1[i] < arr2[j]
                    i++;
                    if (arr2[j] < arr3[k]) {
                        j++;
                    } else if (arr2[j] > arr3[k]) {
                        k++;
                    }
                }
            }
        }

        return res;
    }
}
