
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    int width, height;
    int num = 1;
    byte[] buf = new byte[2];

    private int getNum(byte[] buf) {
        int tmp, res;
//        res = Math.abs(buf[0]);
//        tmp = Math.abs(buf[1]) << 8;
//        res += tmp;
        res = buf[1] << 8 | buf[0] & 0x3fff;
        
        // считывать сразу словми по два байта, считывать файл целиком, отбрасывать с помощь. лог умножения на шестнадцатиричное число несколько старших битов
        return res;
    }

    public static void main(String[] args) {
        Main m = new Main();
        for (int i = 1; i <= 50; i++) {
            try {
                m.readFile(new RandomAccessFile("src/Files/" + i + ".mbv", "r"), 1);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void readFile(RandomAccessFile raf, int number) throws IOException {
//        File file = new File(num + ".txt");
//        FileWriter writer = new FileWriter(file);
//        file.createNewFile();
//        raf.read(buf);
//        width = getNum(buf);
//        // writer.write(width + " ");
//        System.out.println(width);
//        raf.read(buf);
//        height = getNum(buf);
//        // writer.write(height + " ");
//        System.out.println(height);
//        while (raf.read(buf) != -1) {
//            raf.read(buf);
//            //  writer.write(getNum(buf) + " ");
//            System.out.println(getNum(buf));
//        }
//        raf.close();
//        writer.close();
//        num++;   
////        String.toString((255 & 0x0FFF))
        System.out.println(" exp" + (((byte) 255 & 0x0FFF) << 2));
    }

}
