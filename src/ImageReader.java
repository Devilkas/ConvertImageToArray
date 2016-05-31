import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Oleksandr Kushnerov on 31.05.2016.
 */
public class ImageReader {
    BufferedImage img = null;
    File f = null;
    int width;
    int height;

    public ImageReader(String filename) {
        //считывание изображения
        try {
            f = new File(filename);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        //получение width и height изображения
        width = img.getWidth();
        height = img.getHeight();
    }

}
