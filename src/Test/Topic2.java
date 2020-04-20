package Test;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 * 请完成一个函数，输入这样的一个二维数组以及一个整数，判断该数组是否有该整数
 */
public class Topic2 {
//例如下面一个二维数组就是满足上述条件的二维数组
//如果在这个数组中查找数字7，则返回true
//如果查找数字5，则返回false
//eg：
//      1  2  8  9
//      2  4  9  12
//      4  7  10 13
//      6  8  11 15
    public static void main(String[] args) {
        int [] [] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int a=7;
        int b=5;
        boolean f =false;
//        f=JudgeByCycle(array,a);
        f=JudgeByDichotomy(array,15);
        if (f){
            System.out.println("find!");
        }else {
            System.out.println("none!");
        }
    }

    /**
     * 解法1：简单的循环
     * @param array
     * @param n
     * @return
     */
    public static boolean JudgeByCycle(int [] [] array,int n){
        //非空判断
        boolean flag=false;
        if(array.length == 0 || n <=0){
            System.out.println("输入有误");
            return false;
        }else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (n == array[i][j]){
                        flag = true;
                        System.out.println("array"+"["+i+"]"+"["+j+"]");
                        break;
                    }
                }
            }
        }
      return flag;
    }

    /**
     * 解法2：缩减查找范围
     * @param array
     * @param n
     * @return
     */
    public static boolean JudgeByDichotomy(int [][] array,int n){
        //非空判断
        boolean flag=false;
        if (array.length == 0 || n<=0){
            System.out.println("输入有误");
            return false;
        }else {
            int rowLen  =array.length;//行数
            int colLen  =array[0].length;//列数
            int min =array[0][0];
            int max =array[rowLen-1][colLen-1];
            int i=0;
            int j=colLen-1;
            if (n==min){
                flag = true;
                System.out.println("array[0][0]");
            }else if(n==max){
                flag =true;
                System.out.println("array"+"["+(rowLen-1)+"]"+"["+(colLen-1)+"]");
            }else if (n<min || n>max){
                flag =false;
            }else {
                //a[i][j]初始是二维数组的右上角
                while (i<rowLen && j>=0){
                    if (array[i][j] > n)
                    {
                        j--;//左移一列
                    }
                    else if (array[i][j] < n)
                    {
                        i++;//下移一行
                    }
                    else
                    {
                        System.out.println(array[i][j]);
                        flag =true;
                        return true;
                    }

                }
            }
        }
     return flag;
    }

}
