package HomeWork;

import intro.BaseTest;
import org.testng.annotations.Test;

public class AmazonWebApp extends BaseTest {

    @Test(description = "Search with searchBox")
    public static void searchProduct(){
        insertText("//input[@id='twotabsearchtextbox']","Iphone");
    }

    @Test
    public static void sortProductList() throws InterruptedException {
        getProductList("//*[@id=\"brandsRefinements\"]/ul/li","SAMSUNG");

        Thread.sleep(5000);
    }

}
