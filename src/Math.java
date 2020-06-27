import java.util.HashMap;
import java.util.Map;

/**
 * Created by Öî¸ğÀÏÊ¦ on 2018/9/26.
 */
class Math{
	public static final Integer CONSTANT_1 = 666;

	public int math() {
		int a = 1; 
		int b = 2;
		int c = (a + b)*10;
		return c;
	}

	public static void main(String[] args) {
		Math math = new Math();
		math.math();
		Map<String, String> map = new HashMap<>();
		map.put("test", "test");
		new Thread().start();
		System.out.println("end");
	}
}
