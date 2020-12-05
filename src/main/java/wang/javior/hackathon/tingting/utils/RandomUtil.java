package wang.javior.hackathon.tingting.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomUtil {

    /**
     * 从[0, n)这n个数中随机抽取不重复的m个数
     *
     * @param n 大于等于0， 大于m
     * @param m 大于等于0
     */
    public static List<Integer> getRandomNums(int n, int m) {
        List<Integer> res = new ArrayList<>();
        m = Math.max(0, m);
        n = Math.max(0, n);
        if (m >= n) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        int waterMark = n - 1;
        while (m > 0) {
            int randomInt = getRandomInt(0, waterMark);
            swap(arr, waterMark, randomInt);
            waterMark--;
            m--;
        }
        for (int i = waterMark + 1; i < n; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }


    /**
     * 生成从m到n的随机整数[start,end]
     */
    public static int getRandomInt(int start, int end) {
        return start + (int) (Math.random() * (end + 1 - start));
    }
}
