import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Robert Burek
 */
public class Main {


        public static final int BUFFOR = 1024;
        public static void main(String[] args)
        {

            //pakowanie danych zip
            String[] tab = new String[] {"plik.wmv", "plik2.pdf", "inny.txt"};
            byte tmpData[] = new byte[BUFFOR];
            try
            {
                ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("nazwamojegozipa.zip"),BUFFOR));

                for (int i = 0; i < tab.length; i++)
                {
                    BufferedInputStream inS = new BufferedInputStream(new FileInputStream(tab[i]), BUFFOR);
                    zOutS.putNextEntry(new ZipEntry(tab[i]));
                    int counter;
                    while ((counter = inS.read(tmpData, 0, BUFFOR)) != -1)
                        zOutS.write(tmpData, 0, counter);
                    zOutS.closeEntry();
                    inS.close();
                }
                zOutS.close();
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }


            //rozpakowywanie pliku zip
            File katalog = new File(System.getProperty("user.dir")+File.separator+"nazwamojegozipa");
            ZipEntry wpis = null;
            try
            {
                if (!katalog.exists())
                    katalog.mkdir();
                ZipInputStream zInS = new ZipInputStream(new BufferedInputStream(new FileInputStream("nazwamojegozipa.zip"),BUFFOR));
                while ((wpis = zInS.getNextEntry())!= null)
                {
                    BufferedOutputStream fOutS = new BufferedOutputStream(new FileOutputStream(katalog+File.separator+wpis.getName()),BUFFOR);
                    int counter;
                    while ((counter = zInS.read(tmpData, 0, BUFFOR)) != -1)
                        fOutS.write(tmpData, 0, counter);
                    fOutS.close();
                    zInS.closeEntry();
                }
                zInS.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

