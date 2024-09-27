import java.util.*;

public class SingalatonDemo{
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

	
	  BookAdder adder = new BookAdder(scanner);
	  adder.add();

	  BookViewer viewer = new BookViewer();
	  viewer.showAll();
	}
}
class BookStore{
	public String[] books = {};
	private static BookStore store = new BookStore();

	public void add(String strr){
		books = Arrays.copyOf(books, books.length + 1);
		books[books.length -1] = strr;
	}

	public String[] getAll(){
		return books;
	}

	public static BookStore getInstance() {
		return store; 
	}
}
class BookViewer {
	private BookStore store;

	public BookViewer(){
		this. store = BookStore.getInstance();
	}

	public  void showAll(){
		for(var book : store.getAll()){
			System.out.println(book);	
		}
	}
}
class BookAdder{
	private BookStore store;
	private Scanner scanner;

	public BookAdder(Scanner scanner){
		this.store  = BookStore.getInstance();
		this.scanner = scanner;
	}

	public  void add(){
		System.out.print("Book name");
		String book = scanner.nextLine();
		store.add(book);
	}


}