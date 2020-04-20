package Test;

/**
 * 题目：实现一个函数，把字符串中的每个空格都替换为"%20"
 */
public class Topic3 {
//例如输入："We are happy.",则输出:"We%20are%20happy."
    public static void main(String[] args) {
    String str="We are happy.";
    int length = str.length();
    ReplaceBlank_1(str,length);
    ReplaceBlank_2(str,length);
    }

    /**
     * 解法1：String内置函数
     * @param str
     * @param length
     */
    public static void ReplaceBlank_1(String str,int length){
        //数据有效性判断
        if (length<=0||str.isEmpty()){
            System.out.println("data wrong");
        }
        String new_str = str.replaceAll(" ","%20");
        System.out.println(new_str);
    }

    /**
     * 解法2:StringBuilder构造器
     * @param str
     * @param length
     */
    private static void ReplaceBlank_2(String str, int length) {
//        StringBuffer sb = new StringBuffer();//非线程安全，（不能同步访问）
        StringBuilder sb = new StringBuilder();
        if (str.isEmpty()||length<=0){
            System.out.println("data wrong");
            return;
        }
        for (int i = 0; i <length ; i++) {
            if (str.charAt(i) != ' '){
                sb.append(str.charAt(i));
            }else {
                sb.append("%20");
            }
        }
        System.out.println(sb.toString());
    }
}
