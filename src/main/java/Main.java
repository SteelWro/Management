import api.ProductFacade;
import api.ProductService;
import api.UserRegisterLoginFacade;
import entity.Boots;
import entity.Cloth;
import entity.Enum.Colors;
import entity.Enum.Material;
import entity.Enum.SkinType;
import entity.Product;
import entity.User;
import entity.parser.BootsParser;
import entity.parser.ClothParser;
import entity.parser.ColorParser;
import facade.ProductFacadeImpl;
import facade.UserRegisterLoginFacadeImpl;
import service.ProductServiceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void startMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Zaloguj się");
        System.out.println("2 - Usuń użytkownika");
        System.out.println("3 - Zarejestruj się");
        System.out.println("0 - Wyjdź");
    }

    public static void loggedMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Dodaj nowy produkt");
        System.out.println("2 - usuń produkt");
        System.out.println("3 - wyświetl produkty");
        System.out.println("0 - Wyloguj się");
    }

    public static void productTypeMenu() {
        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
        System.out.println("3 - Inne");
    }

    public static Product createOtherProduct() {
        String productName; Colors color;
        Float price, weight;
        Integer count;
        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Color: RED, BLUE, GREEN, WHITE, BLACK, YELLOW ");
        color = ColorParser.strToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        return new Product(1L, productName, price, weight, color, count);
    }

    public static Product createBootsProduct() {
        String productName; Colors color;
        Float price, weight;
        Integer count, size;
        SkinType skin;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Color: RED, BLUE, GREEN, WHITE, BLACK, YELLOW ");
        color = ColorParser.strToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.nextInt();

        System.out.println("type skin: ");
        skin = BootsParser.strToBoots(scanner.next());


        return new Boots(1L, productName, price, weight, color, count, size, skin);
    }

    public static Product createClothProduct() {
        String productName, size;
        Float price, weight;
        Integer count;
        Material material;
        Colors color;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Color: RED, BLUE, GREEN, WHITE, BLACK, YELLOW ");
        color = ColorParser.strToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.nextLine();

        System.out.println("Material: LEATHER,FUR,COTTON,WOOL,POLYESTER,DEFAULT ");
        material = ClothParser.strToCloth(scanner.next());


        return new Cloth(1L, productName, price, weight, color, count, size, material);
    }



    public static void main(String[] args) {
        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImpl.getInstance();
        ProductFacade productFacade = ProductFacadeImpl.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();
        boolean appOn = true;
        boolean loggedOn = false;
        int read;

        while (appOn) {
            startMenu();
            read = scanner.nextInt();

            switch (read) {
                case 1:
                    System.out.println("Podaj login:");
                    String loginLog = scanner.next();
                    System.out.println("Podaj hasło:");
                    String passwordLog = scanner.next();
                    if (userFacade.loginUser(loginLog, passwordLog)) {
                        loggedOn = true;
                        System.out.println("Zalogowałeś się!");
                    } else {
                        System.out.println("Niepoprawne dane!");
                    }
                    break;
                case 3:
                    System.out.println("Podaj login:");
                    String loginReg = scanner.next();
                    System.out.println("Podaj hasło:");
                    String passwordReg = scanner.next();
                    User user = new User(1L, loginReg, passwordReg);
                    System.out.println(userFacade.registerUser(user));

                    break;
                case 2:
                    System.out.println("Podaj login:");
                    String readLogin = scanner.next();
                    System.out.println(userFacade.removeUser(readLogin));

                    case 0:
                    appOn = false;
                    break;
            }

            while (loggedOn) {

                loggedMenu();
                read = scanner.nextInt();

                switch (read) {
                    case 1:
                        productTypeMenu();
                        read = scanner.nextInt();
                        Product product = null;
                        switch (read) {
                            case 1:
                                product = createBootsProduct();
                                break;
                            case 2:
                                product = createClothProduct();
                                break;
                            case 3:
                                product = createOtherProduct();
                                break;
                        }
                        System.out.println(productFacade.createProduct(product));
                        break;
                    case 2:
                        System.out.println("Podaj nazwe produktu do usunięcia");
                        String name = scanner.next();
                        System.out.println(productFacade.removeProduct(name));
                        break;
                    case 3:
                        System.out.println(productFacade.getAllProducts());
                        break;
                    case 0:
                        loggedOn = false;
                        break;
                }


            }//end while


        }


    }
}
