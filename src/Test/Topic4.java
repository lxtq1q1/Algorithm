package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class Topic4 {
//例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}
// 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
    public static void main(String[] args) {
    int[] array ={1,2,3,2,2,2,5,4,2};
    int length = array.length;
    int x =Solution_2(array,length);
        System.out.println(x);
    }

    /**
     * 解法1：Hashmap的containsKey&
     * @param array
     * @param length
     * @return
     */
    public static int  Solution_1(int[] array,int length){
        HashMap<Integer,Integer> countMap = new HashMap<Integer, Integer>();
        for (int i = 0; i <length ; i++) {
            if (!countMap.containsKey(array[i])) //如果map里面没有这个键，则将键值对写入map
                countMap.put(array[i],1);
            else
                countMap.put(array[i],countMap.get(array[i])+1);//若已经存在，则取出原来的值并加一
        }
        //遍历map，判断所有的键值对，若有值大于length/2 则返回该键；否则返回0
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if (entry.getValue()*2>length){
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 解法2：先把数组排序，如果有符合条件的值，那么中间的下标取出的值必定重复次数最多
     * 这样只需要取出它来判断出现的次数
     * @param array
     * @param length
     * @return
     */
    public static int Solution_2(int[] array,int length){
        Arrays.sort(array);
        int position = length/2;
        int num = array[position];
        int count = 0;
        for (int i = 0; i <length ; i++) {
            if (num == array[i]){
                count++;
            }
        }
        if (count*2>length){
            return array[position];
        }
        return 0;
    }
}
