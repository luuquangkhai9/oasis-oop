import java.io.*;

public class Utils {

    /**
     * hello
     * @param path .
     * @return string .
     */
    public static String readContentFromFile(String path) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while (reader.readLine() != null) {
                line = reader.readLine();
                result.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * my name.
     * @param path .
     * @param content .
     */
    public static void writeContentToFile(String path, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, false));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * luu quang khai
     * @param path .
     * @param content .
     */
    public static void AppendwriteContentToFile(String path, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 22024521
     * @param folderPath .
     * @param fileName .
     * @return file.
     */
    public static File findFileByName(String folderPath, String fileName) {
        File folders = new File(folderPath);
        // Kiểm tra thư mục tồn tại không
        if (!folders.exists() || !folders.isDirectory()) {
            System.out.println("Thư mục không tồn tại");
            return null;
        }
        // Lấy danh sách tệp trong thư mục
        File[] files = folders.listFiles();
        //  kiểm tra tên
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    return file;
                }
            }
        }

        System.out.println("Không tìm thấy file" );
        return null;
    }
}
