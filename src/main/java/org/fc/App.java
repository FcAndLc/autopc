package org.fc;

import org.fc.auto.OperaInterface;
import org.fc.auto.khgl.OperKhglImpl;
import org.fc.auto.login.LoginService;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1.多层嵌套iframe需要一级一级的查
 * 2.iframe可以打印出src，从而判定是否是需要的iframe
 * 3.iframe(int i)下标从0开始，页面iframe查看下标不可靠，最好不用下标
 * 如果使用路径可以使用包含、前缀，后缀等方法，例如//iframe[starts-with(@src, '/mng/xd/firminfo/add-ui-new')]
 * //div[contains(@class, 'example')]
 * //input[starts-with(@id, 'user')]
 * //div[substring(@id, string-length(@id) - string-length('suffix') + 1) = 'suffix']
 */
public class App {
    private static Map<String, Object> temp = new HashMap<>();
    private static OperaInterface khglService=new OperKhglImpl();
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\install\\chromedriver-win64\\chromedriver.exe");// chromedriver服务地址
//        ChromeOptions options=new ChromeOptions();
//        options.setPageLoadTimeout(Duration.ofSeconds(20));
        WebDriver rootWeb = new ChromeDriver();
        //设置全局页面加载完成才执行，最长加载20s
        rootWeb.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //登录
        LoginService.login(rootWeb,"caoxue","qwer1234!");
        //客户管理
        khglService.dothing(rootWeb);
    }


}
