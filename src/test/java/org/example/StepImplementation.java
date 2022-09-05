package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest{

    @Step("<time> saniye bekle")
    public void waitForsecond(int time) throws InterruptedException {
        Thread.sleep(time*1000);
    }
    @Step("<id> İd'li elementi bul ve tıkla")
    public void clickByid(String id){
        appiumDriver.findElement(By.id(id)).click();
        System.out.println("Element tıklandı.");
    }

    @Step("<xpath> Xpath'li elementi bul ve tıkla")
    public void clickByxpath(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
        System.out.println("Element tıklandı.");
    }
    @Step("<id> İd'li elementi bul ve <text> değerini yaz")
    public void sendKeysByid(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        System.out.println(text +"değeri yazıldı");
    }
    @Step("<xpath> Xpath'li elementi bul ve <text> değerini yaz")
    public void sendKeysByxpath(String xpath,String text){
        appiumDriver.findElement(By.xpath(xpath)).sendKeys(text);
        System.out.println(text +"değeri yazıldı");
    }
    @Step("<id> İd'li element <text> değerini içeriyor mu kontrol et")
    public void ControltoElementByid(String id,String text){
        MobileElement element = appiumDriver.findElement(By.id(id));
        System.out.println("Alınan elementın text değeri " + element.getText());
        Assert.assertTrue("Verilen text değeri ile alınan text değeri eşit değil",element.getText().equals(text));
    }

    @Step("Sayfayı yukarı kaydır")
    public void swipeByup(){
        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms

        int edgeBorder = 300; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        System.out.println("dims====="+ dims);
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);

        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }





    public void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    @Step("<xpath> Xpath'li elementler arasında rasgele bir tanesine tıkla")
    public void clickByrandomElement(String xpath){
        List<MobileElement> elements = appiumDriver.findElements(By.xpath(xpath));
        System.out.println("Total elements : " + elements.size());
        Random rand = new Random();
        int index = rand.nextInt(elements.size()-1);
        System.out.println("idex====" + index);
        elements.get(index).click();
    }

}

