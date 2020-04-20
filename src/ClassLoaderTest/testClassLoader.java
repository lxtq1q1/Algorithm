package ClassLoaderTest;

public class testClassLoader {
    public void test(){
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

    }

    public static void main(String[] args) {
        testClassLoader testClassLoader = new testClassLoader();
        testClassLoader.test();
    }

}
