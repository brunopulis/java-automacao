package testes.e2e;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LojinhaWebTest {
    private WebDriver driver = null;

    @Before
    public void setUp () throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/pulis/drivers/chromedriver/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://165.227.93.41/lojinha-web/");

        WebElement usuario = driver.findElement(By.cssSelector("#usuario"));
        WebElement senha = driver.findElement(By.cssSelector("#senha"));
        WebElement submit = driver.findElement(By.cssSelector("[type=submit]"));

        usuario.sendKeys("pulis.fake");
        senha.sendKeys("123456");
        submit.click();
    }

    @After
    public void tearDown() {
        LojinhaWebTest.driver.quit();
    }

    @Test
    public void testValidarDadosDeUmProduto () {
        driver.findElement(By.linkText("Redmi Xiaomi 7")).click();

        String produtoNome = driver.findElement(By.cssSelector("#produtonome")).getAttribute("value");
        Assert.assertEquals("Redmi Xiaomi 7", produtoNome);
        String componenteNome = driver.findElements(By.cssSelector(".title")).get(0).getText();
        Assert.assertEquals("Lojinha carregador", componenteNome);
    }

    @Test
    public void testCriandoNovoProduto () {
        WebElement adicionarProduto = driver.findElement(By.linkText("ADICIONAR PRODUTO"));
        adicionarProduto.click();

        WebElement nomeProduto = driver.findElement(By.id("produtonome"));
        WebElement valorProduto = driver.findElement(By.id("produtovalor"));
        WebElement coresProduto = driver.findElement(By.id("produtocores"));
        WebElement submitButton = driver.findElements(By.cssSelector(".btn")).get(0);


        nomeProduto.sendKeys("PS9");
        valorProduto.sendKeys("4500");
        coresProduto.sendKeys("branco, preto");
        submitButton.click();

        String successMessage = driver.findElement(By.cssSelector(".toast")).getText();
        Assert.assertEquals("Produto adicionado com sucesso", successMessage);
    }
}
