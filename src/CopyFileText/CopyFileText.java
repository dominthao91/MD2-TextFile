package CopyFileText;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    public List<String> readFile(String path) {
        List<String> strings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line + "\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Tệp nguồn không tồn tại hoặc bị lỗi.");
        }
        return strings;
    }

    public void writeFile(String path, List<String> strings) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String string: strings) {
                bufferedWriter.write(string);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Tệp nguồn không tồn tại hoặc bị lỗi.");
        }

    }
    public static void main(String[] args) {
        CopyFileText copyTextFile = new CopyFileText();

        List<String> strings = copyTextFile.readFile("folder.txt");
        copyTextFile.writeFile("foldercoppy.txt", strings);
    }
}
