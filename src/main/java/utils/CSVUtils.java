package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CSVUtils {
    public static void writeCSV(List<Map<String, String>> data, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.append("Product Title,Price,Rating,Number of Reviews\n");
        for (Map<String, String> row : data) {
            writer.append(String.format("%s,%s,%s,%s\n",
                    row.get("Product Title"), row.get("Price"), row.get("Rating"), row.get("Number of Reviews")));
        }
        writer.flush();
        writer.close();
    }
}
