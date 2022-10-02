import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {


    public static final String JPG = ".jpg";

    public static ChromeDriver setupDriver(){
        System.setProperty("webdriver.chrome.driver","res\\chromedriver.exe");
        return new ChromeDriver();
    }

    public static final String WIKICAR = "https://en.wikipedia.org/wiki/car";
    public static final String SAUCE = "https://www.saucedemo.com";
    public  static final String FOLDER1 = "C:\\Users\\ortal\\OneDrive\\שולחן העבודה\\screenshots\\";
    public static final String ENVIRONMENT = "//*[@id=\"mw-content-text\"]/div[1]/p[49]";
    public static final String TXT = ".txt";
    public static final String PARAGRAPH = "Environmental_effects";

    public static final String MYSTORE = "http://automationpractice.com/index.php";
    public static final String MYSTORESEARCH = "search_query_top";
    public static final String SEARCHTSHIRTS = "T-SHIRTS";
    public  static final String SEARCHBTN = "//*[@id=\"searchbox\"]/button";
    public  static final String WIKICARSEARCHFIELD = "searchInput";
    public  static final String WIKICARSEARCHBTN = "searchButton";
    public  static final String WIKITSHIRTS = "https://en.wikipedia.org/wiki/T-shirt";


}
