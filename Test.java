public class Test{
	public static void main(String[] args) {
StringBuilder sb = new StringBuilder();
System.out.printf("Capacity : %d%n", sb.capacity());
System.out.printf("Length : %d%n", sb.length());
sb.append("Greetingsss");
System.out.printf("Capacity : %d%n", sb.capacity());
System.out.printf("Length : %d%n", sb.length());
}
}