/**
 * Created by Oleksandr Kushnerov on 31.05.2016.
 */
public class SecondImage {
    int s21 = 0;
    int count = 0;
    int Str21 = 0;
    int s22 = 0;
    int Str22 = 0;

    public SecondImage() {
        ImageReader imageReader = new ImageReader("2.png"); //���������� ����������� � ��������� width � height �����������
        boolean[][] Matrix = new boolean[imageReader.height][imageReader.width]; //������� 1-�� ����������� � ���� true/false
        int[][] resultMatrix = new int[imageReader.height][imageReader.width];
        //��������������� � ������
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
        while (s21 < imageReader.width) {
            for (int i = 0; i < imageReader.height; i++) {
                Str21 += resultMatrix[i][s21];
                count++;
            }
            s21++;
            System.out.print(Str21 / count + " ");
            count = 0;
            Str21 = 0;
        }
        System.out.println();
        //�������������� ������� � 0||1.
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
        //������ ������� �����������
        System.out.println();
        for (int x = 0; x < imageReader.height; x++) {
            for (int y = 0; y < imageReader.width; y++) {
                System.out.print(resultMatrix[x][y] + " ");
            }
            System.out.println("  ");
        }
        System.out.println();
        while (s22 < imageReader.width) {
            for (int i = 0; i < imageReader.height; i++) {
                Str22 += resultMatrix[i][s22];
            }
            s22++;
            if (Str22 % 2 == 0) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
            Str22 = 0;
        }
        //������ �����������
//        try{
//            imageReader.f = new File("Output2.jpg");
//            ImageIO.write(imageReader.img, "jpg", imageReader.f);
//        }catch(IOException e){
//            System.out.println(e);
//        }

    }
}
