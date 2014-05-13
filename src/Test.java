import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;

public class Test {
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.load(new BufferedInputStream(new FileInputStream("default.cfg")));

		System.out.println(props.getProperty("axis.left.x"));
	}
}
