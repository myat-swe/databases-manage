import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DataPreparation {
  
  private static String source = "<data in raw.txt(see telegram)>";
  
  public static void main(String[] args) {
    
    var stuArray = source.split("-");
    
    Arrays.stream(stuArray)
      .map(s -> s.substring(1, s.length() - 1))
      .map(s -> s.split(","))
      .map(array -> {
        var email = cleanStr(array[0]).replace(" ", "").toLowerCase().concat(getRandomEmailSuffix());
        var phone = array[2].strip();
        return "(%s, '%s'),".formatted(phone, email);
      }).forEach(System.out::println);
    
  }
  
  static String getRandomEmailSuffix() {
    var list = new ArrayList<String>();
    Collections.addAll(list, "@gmail.com", "@yahoo.com", "@microsoft.com");
    Collections.shuffle(list);
    return list.getFirst();
  }
  
  static String cleanStr(String s) {
    return s.startsWith("'") || s.endsWith("'") ? s.replaceAll("'", "").strip() : s.strip();
  }
}