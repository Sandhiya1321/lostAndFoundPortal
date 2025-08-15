import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class file {
    private static final String fileName="details.txt";
    public static void saveDetail(details detail) throws IOException {
        FileWriter fw=new FileWriter(fileName,true);
        fw.write(detail.toString()+"\n");
        fw.close();
    }
    public static List<details> loadDetail() throws IOException{
        List<details> detail=new ArrayList<>();
        File file=new File(fileName);
        if(!file.exists()) return detail;
        FileReader fr=new FileReader(fileName);
        StringBuilder sb=new StringBuilder();
        int ch;
        while((ch=fr.read())!=-1){
            sb.append((char)ch);
        }
        fr.close();
        String[] lines=sb.toString().split("\n");
        for(String line:lines){
            if(!line.trim().isEmpty()){
                detail.add(details.fromString(line));
            }
        }
        return detail;
    }
}
