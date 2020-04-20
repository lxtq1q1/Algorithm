package Test;

import java.util.List;

/**
 * 题目：找出数组中的重复的数字
 */
public class Topic1 {

//在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中的某些数字是重复的，但不知道哪几个数字重复，也不知道每个数字的重复次数
//请找出数组中重复的数字
//eg：输入长度为7的数组，｛2，3，1，0，2，5，3｝

    public static void main(String[] args) {
       int arrry[] = new int[] {2,3,1,0,2,5,3};
       int n = arrry.length;
       FindRepeatByArray_1(n,arrry);
       FindRepeatByArray_2(n,arrry);
    }

    /**
     * 解法1：数组直接循环
     * @param n
     * @param array
     * @return
     * 时间复杂度O(n^2)
     */
    public static boolean FindRepeatByArray_1(int n,int[] array){
        if (n == 0||array.length<=0) return false;
        for (int j = 0; j <n ; j++) {
            if (array[j]<0||array[j]>n-1){
                return false;
            }
        }
            for (int i = 0; i <array.length ; i++) {
                int count =0;
                int s=array[i];
                for (int j = i+1; j <array.length ; j++) {
                    if (s == array[j]){
                        count++;
                    }
                }
                if (count==1){
                    System.out.println(s);
                }
            }
            return true;
    }

    /**
     * 解法2：排序
     * @param n
     * @param array
     * @return
     * 时间复杂度O(n)
     */
    public static boolean FindRepeatByArray_2(int n,int[] array){
        if (n==0||array.length<=0){
            return false;
        }
        for (int j = 0; j <n ; j++) {
            if (array[j]<0||array[j]>n-1){
                return false;
            }
        }
        for (int i = 0; i <n ; i++) {
            while (array[i]!=i){
                if (array[i]==array[array[i]]){
                    System.out.println(array[i]);
                    break;
                }
                int temp = array[i];
                array[i] = array[temp];
                array[temp] =temp;
            }
        }
        return false;
    }
}





