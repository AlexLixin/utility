import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageMirror {
    public static void main(String[] args) throws IOException{
        File file = null;
        BufferedImage image = null;

        try {
            file = new File("C:/Users/LXI/Desktop/tmp/icon_prevPage_16px.png");
            image = ImageIO.read(file);

            int width = image.getWidth();
            int height = image.getHeight();

            for (int j = 0; j < height; j++) {
                int l = 0, r = width - 1;
                while (l < r) {
                    int pl = image.getRGB(l, j);
                    int pr = image.getRGB(r, j);

                    image.setRGB(l, j, pr);
                    image.setRGB(r, j, pl);

                    l++;
                    r--;
                }
            }

            file = new File("C:/Users/LXI/Desktop/tmp/icon_nextPage_16px.png");
            ImageIO.write(image, "png", file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
