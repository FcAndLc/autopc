package org.fc.auto.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginService {
    public static void login(WebDriver web, String uname, String pword){
        web.switchTo().defaultContent();
        //打开地址
        web.get("http://172.16.1.65:30015/mng/login");
        //输入账号
        WebElement username = web.findElement(By.id("LAY-user-login-username"));
        username.sendKeys(uname);

        //输入密码
        WebElement password = web.findElement(By.id("LAY-user-login-password"));
        password.sendKeys(pword);
        //登录
        waitThenClick(web,By.cssSelector("button[lay-filter=\"LAY-user-login-submit\"]"));
//        WebElement element = web.findElement(By.cssSelector("button[lay-filter=\"LAY-user-login-submit\"]"));
//        element.click();
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //设置全屏
                web.manage().window().fullscreen();
            }
        }.start();


    }
    private static void waitThenClick(WebDriver driver, By by){
        // 设置等待时间
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 最多等待10秒
        // 等待元素变为可点击状态
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }
}
