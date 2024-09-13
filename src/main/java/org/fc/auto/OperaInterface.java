package org.fc.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface OperaInterface {
    void dothing(WebDriver webDriver);
   default void sleep(int s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    default String getLastHandler(WebDriver webDriver){
        //获取当前打开窗口的所有句柄-LinkHashSet实现，虽然去重但是有序
        Set<String> Allhandles = webDriver.getWindowHandles();
        ArrayList<String> lst = new ArrayList<>(Allhandles);
        return lst.get(lst.size()-1);
    }

    //滚动
    default void scrollDown(WebDriver driver, int pixelCount) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // 向下滑动指定的像素数
        js.executeScript("window.scrollBy(0, " + pixelCount + ")");
    }
    //执行js
    default void js(WebDriver driver, String javascript) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // 向下滑动指定的像素数
        js.executeScript(javascript);
    }
    //等待能够提交的时候提交
    default void waitThenClick(WebDriver driver, By by){
        // 设置等待时间
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 最多等待10秒
        // 等待元素变为可点击状态
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }


    /**
     * 通过父元素找子元素，如果子元素存在则返回
     * @param parent
     * @param child
     */
    default void waitShowClick(WebElement parent,By child){
       int num=15;
       while(num >0){
           List<WebElement> elements = parent.findElements(child);
           if(elements.size()>0){
               return ;
           }
           sleep(200);
           num--;
        }


    }


}
