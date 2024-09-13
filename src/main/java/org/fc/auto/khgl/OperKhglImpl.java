package org.fc.auto.khgl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class OperKhglImpl extends OperaKhglAbstract{
    @Override
    public void dothing(WebDriver webDriver) {
        WebElement element = webDriver.findElement(By.cssSelector("li[data-name=\"R016\"]"));
        String aClass = element.getAttribute("class");
        if (!aClass.contains("layui-nav-itemed")) {
            //如果不包含就是不处于打开状态就打开它
            element.click();
        }
        //客户基本信息管理
        WebElement khgl = webDriver.findElement(By.cssSelector("dd[data-name=\"R016002\"]"));
        String bclass = khgl.getAttribute("class");
        if (!bclass.contains("layui-nav-itemed")) {
            //如果不包含就是不处于打开状态就打开它
            khgl.click();
        }
        //点击客户管理页面
        WebElement element1 = webDriver.findElement(By.cssSelector("dd[data-name=\"R016002001\"]"));
        element1.findElement(By.cssSelector("a")).click();
        toAddCustmer(webDriver);
    }
    private void toAddCustmer(WebDriver rootWeb) {
        //找到第二个iframe,第一个是iframe是主页
        WebDriver towLevelWeb = rootWeb.switchTo().frame(1);
        //等待直到提交按钮可以点击
        sleep(1000);
        //客户新增
        WebElement element = towLevelWeb.findElement(By.cssSelector("button[data-type=\"add\"]"));
        element.click();
        //获取弹窗
        WebDriver threeLevelWeb = towLevelWeb.switchTo().frame(towLevelWeb.findElement(By.tagName("iframe")));
        if (true) {
            //添加企业
            addQy(threeLevelWeb);
        }
    }

    private void addQy(WebDriver threeLevelWeb) {
        WebElement selectElement = threeLevelWeb.findElement(By.cssSelector("tr[data-index=\"1\"]"));
        selectElement.findElement(By.cssSelector("a[lay-event=\"choice\"]")).click();
        //切回页面内容
        WebDriver rootWeb = threeLevelWeb.switchTo().defaultContent();
        WebDriver newThreeFrame = rootWeb.switchTo().frame(1);
        WebElement webElement =newThreeFrame.findElement(By.xpath("//iframe[starts-with(@src, '/mng/xd/firminfo/add-ui-new')]"));
        String src = webElement.getAttribute("src");
        System.out.printf("目前位置在iframe.src="+src);
        WebDriver frame = rootWeb.switchTo().frame(webElement);
        //企业名称
        WebElement element = frame.findElement(By.cssSelector("input[name=\"firmname\"]"));
        element.sendKeys("自动测试企业名称");
        //统一社会信用代码
        WebElement tydm = frame.findElement(By.cssSelector("input[name=\"yingyezz\"]"));
        tydm.sendKeys("NTRR5T55CNNVSS5S11");
        //下拉选择
        WebElement proidDc = frame.findElement(By.className("proidDc"));
        proidDc.findElement(By.cssSelector(".layui-form-select>.layui-select-title>input")).click();
        proidDc.findElement(By.cssSelector(".layui-form-select>.layui-anim-upbit>dd[lay-value=\"120000\"]")).click();
        List<WebElement> div = proidDc.findElements(By.className("layui-input-inline"));
        //循环等待
        waitShowClick(div.get(1),By.cssSelector(".layui-anim-upbit>dd[lay-value=\"120100\"]"));
        div.get(1).findElement(By.cssSelector(".layui-select-title>input")).click();
        div.get(1).findElement(By.cssSelector(".layui-anim-upbit>dd[lay-value=\"120100\"]")).click();
        //循环等待
        waitShowClick(div.get(2),By.cssSelector(".layui-anim-upbit>dd[lay-value=\"120102\"]"));
        div.get(2).findElement(By.cssSelector(".layui-select-title>input")).click();
        div.get(2).findElement(By.cssSelector(".layui-anim-upbit>dd[lay-value=\"120102\"]")).click();
        sleep(500);
        WebElement input1 = div.get(3).findElement(By.cssSelector("input"));
        input1.sendKeys("地址");
        //同上
        List<WebElement> syncoftop = frame.findElements(By.className("syncoftop"));
        syncoftop.stream().forEach(f->{
            sleep(50);
            f.click();
        });
        scrollDown(frame,500);
        //所属行业
        WebElement tradesSelectDc = frame.findElement(By.className("tradesSelectDc"));
        tradesSelectDc.findElement(By.cssSelector(".layui-form-select>.layui-select-title>input")).click();
        tradesSelectDc.findElement(By.cssSelector(".layui-form-select>.layui-anim-upbit>dd[lay-value=\"01\"]")).click();
        List<WebElement> div1 = tradesSelectDc.findElements(By.className("layui-input-inline"));
        //循环等待
        waitShowClick(div1.get(1),By.cssSelector(".layui-anim-upbit>dd[lay-value=\"01A\"]"));
        div1.get(1).findElement(By.cssSelector(".layui-select-title>input")).click();
        div1.get(1).findElement(By.cssSelector(".layui-anim-upbit>dd[lay-value=\"01A\"]")).click();
        //循环等待
        waitShowClick(div1.get(2),By.cssSelector(".layui-anim-upbit>dd[lay-value=\"01A01\"]"));
        div1.get(2).findElement(By.cssSelector(".layui-select-title>input")).click();
        div1.get(2).findElement(By.cssSelector(".layui-anim-upbit>dd[lay-value=\"01A01\"]")).click();
        //循环等待
        waitShowClick(div1.get(3),By.cssSelector(".layui-anim-upbit>dd[lay-value=\"01A01011\"]"));
        div1.get(3).findElement(By.cssSelector(".layui-select-title>input")).click();
        div1.get(3).findElement(By.cssSelector(".layui-anim-upbit>dd[lay-value=\"01A01011\"]")).click();

        //企业规模
        WebElement enterprisescaleDc = frame.findElement(By.className("enterprisescaleDc"));
        enterprisescaleDc.findElement(By.cssSelector(".layui-form-select>.layui-select-title>input")).click();
        enterprisescaleDc.findElement(By.cssSelector(".layui-form-select>.layui-anim-upbit>dd[lay-value=\"2\"]")).click();
        //联系人姓名
        WebElement lxrnname = frame.findElement(By.id("lxrnnameinput"));
        lxrnname.sendKeys("联系人姓名");
        //联系人手机号
        WebElement lxrnshjiinput = frame.findElement(By.id("lxrnshjiinput"));
        lxrnshjiinput.sendKeys("13312341234");
        //成立时间
        js(frame," document.getElementById('establishedtime').value='2024-12-22'");
        scrollDown(frame,500);
        //法人姓名
        WebElement farnnameinput = frame.findElement(By.id("farnnameinput"));
        farnnameinput.sendKeys("法人姓名");
        //最终控制人
        WebElement finalcontrollerinput = frame.findElement(By.id("finalcontrollerinput"));
        finalcontrollerinput.sendKeys("最终控制人");
        //提交
        waitThenClick(frame,By.cssSelector("button[lay-filter=\"subBtn\"]"));

    }
}
