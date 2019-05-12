import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Robert Burek
 */
public class FiltrRozszerzenPliki extends FileFilter {

    String samePliki;
    public FiltrRozszerzenPliki(String same_pliki) {
        this.samePliki=same_pliki;

    }

    @Override
    public boolean accept(File f) {
        return !f.isDirectory();
    }

    @Override
    public String getDescription() {
        return samePliki;
    }
}
