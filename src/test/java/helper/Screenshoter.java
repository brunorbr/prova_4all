package helper;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshoter {
    private Screenshot screenshot;
    private String timeStampFileName;

    public Screenshoter(WebDriver driver){
        this.screenshot = new AShot().takeScreenshot(driver);
    }

    public String setTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public void setFileName(){
        this.timeStampFileName = setTimestamp();
    }

    public void writeFile() throws IOException {
        setFileName();
        ImageIO.write(
                screenshot.getImage(),
                "jpg",
                new File("\\testscreenshots\\"+ timeStampFileName + ".jpg"));
    }
}
