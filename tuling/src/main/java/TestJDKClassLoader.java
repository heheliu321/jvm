/**
 * Àà¼ÓÔØÆ÷
 * Created by Öî¸ð  on 2018/9/26.
 */
public class TestJDKClassLoader {

    public static void main(String[] args){
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
    }
}
