import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
public class AppData {
    private String[] header;
    private int[][] data;
    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }
    public String[] getHeader() {
        return header;
    }
    public void setHeader(String[] header) {
        this.header = header;
    }
    public int[][] getData() {
        return data;
    }
    public void setData(int[][] data) {
        this.data = data;
    }
    public void save(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(String.join(";", header));
            writer.write("\n");
            for (int[] row : data) {
                String rowString = Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .reduce((a, b) -> a + ";" + b)
                        .orElse("");
                writer.write(rowString);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String[] header = {"Column1", "Column2", "Column3"};
        int[][] data = {
                {100, 200, 123},
                {300, 400, 500}
        };
        AppData appData = new AppData(header, data);
        appData.save("output.csv");
    }
}