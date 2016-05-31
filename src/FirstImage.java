/**
 * Created by Oleksandr Kushnerov on 31.05.2016.
 */
public class FirstImage {
    int s11 = 0;
    int count = 0;
    int Str11 = 0;
    int s12 = 0;
    int Str12 = 0;

    public FirstImage() {
        ImageReader imageReader = new ImageReader("1.png"); //считывание изображения и получение width и height изображения
        boolean[][] Matrix = new boolean[imageReader.height][imageReader.width]; //Матрица 1-го изображения в виде true/false
        int[][] resultMatrix = new int[imageReader.height][imageReader.width];
        //конвертирование в массив
        for (int y = 0; y < imageReader.height; y++) {
            for (int x = 0; x < imageReader.width; x++) {
                int p = imageReader.img.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                int avg = (r + g + b) / 3;
                resultMatrix[x][y] = avg;
                System.out.print(resultMatrix[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
        while (s11 < imageReader.width) {
            for (int i = 0; i < imageReader.height; i++) {
                Str11 += resultMatrix[i][s11];
                count++;
            }
            s11++;
            System.out.print(Str11 / count + " ");
            count = 0;
            Str11 = 0;
        }
        System.out.println();
        //преобразование матрицы к 0||1.
        for (int i = 0; i < imageReader.height; i++) {
            for (int y = 0; y < imageReader.width; y++) {
                if (resultMatrix[i][y] >= 255) {
                    {
                        Matrix[i][y] = false;
                        resultMatrix[i][y] = 0;
                    }
                } else {
                    Matrix[i][y] = true;
                    resultMatrix[i][y] = 1;
                }
            }
        }
        System.out.println();
        //вывыод матрицы изображения
        System.out.println();
        for (int x = 0; x < imageReader.height; x++) {
            for (int y = 0; y < imageReader.width; y++) {
                System.out.print(resultMatrix[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
        while (s12 < imageReader.width) {
            for (int i = 0; i < imageReader.height; i++) {
                Str12 += resultMatrix[i][s12];
            }
            s12++;
            if (Str12 % 2 == 0) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
            Str12 = 0;
        }

        //запись изображения
//        try{
//            imageReader.f = new File("Output1.jpg");
//            ImageIO.write(imageReader.img, "jpg", imageReader.f);
//        }catch(IOException e){
//            System.out.println(e);
//        }
    }
}
