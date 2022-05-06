package ReaderWriter;

import test.PropValue;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVWrite {

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }


    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public void addRecordToCSV(LinkedList<String[]> dataLines) throws IOException {
        dataLines.addFirst(new String[]{"bookingName", "flightNumber", "seatCategory", "numberOfSeats", "FinalPrice"});
        List<String> collect = dataLines.stream()
                .map(this::convertToCSV)
                .collect(Collectors.toList());
        String filename = PropValue.MainConfig.getProperty("OUTPUTFILE");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(
                System.getProperty("user.dir") + "/src/main/java/OutputFiles/" + filename))) {
            for (String line : collect) {
                bw.write(line);
                bw.newLine();
            }
        }
    }
        public void addRecordToErrorFile(List<String> content) throws IOException {
            String path = System.getProperty("user.dir") + "/src/main/java/OutputFiles/";
            String filename = path + PropValue.MainConfig.getProperty("ERRORFILE");
            FileWriter writer = new FileWriter(filename);
                for (String line : content) {
                    writer.write(line +System.lineSeparator());
                }
            writer.close();
            }

    public static class ErrorReason implements Writer {

        @Override
        public void writeToFile(String bookingName, String flightNumber, String category, String numberOfSeats, String finalPrice) {
            String reason = category;
            String content = "Please check"+"  "+bookingName+":"+"  "+ reason;
            PropValue.errorRecord.add(content);
        }
    }
}

