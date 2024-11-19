import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BookCategory {
    String name;
    List<BookCategory> subcategories;

    BookCategory(String name) {
        this.name = name;
        this.subcategories = new ArrayList<>();
    }

    void addSubcategory(BookCategory subcategory) {
        this.subcategories.add(subcategory);
    }

    void displayCategories(String prefix) {
        System.out.println(prefix + "- " + this.name);
        for (BookCategory subcategory : subcategories) {
            subcategory.displayCategories(prefix + "  ");
        }
    }
}

public class LibraryBookOrganizer {
    private static BookCategory root = new BookCategory("Library");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Book Organizer ---");
            System.out.println("1. Display Categories");
            System.out.println("2. Add Category");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Library Catalog ---");
                    root.displayCategories("");
                    break;

                case 2:
                    System.out.print("Enter parent category name: ");
                    String parentName = scanner.nextLine();
                    BookCategory parent = findCategory(root, parentName);

                    if (parent != null) {
                        System.out.print("Enter new category name: ");
                        String newCategoryName = scanner.nextLine();
                        parent.addSubcategory(new BookCategory(newCategoryName));
                        System.out.println("Category added successfully!");
                    } else {
                        System.out.println("Parent category not found.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static BookCategory findCategory(BookCategory current, String name) {
        if (current.name.equalsIgnoreCase(name)) {
            return current;
        }

        for (BookCategory subcategory : current.subcategories) {
            BookCategory found = findCategory(subcategory, name);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}
