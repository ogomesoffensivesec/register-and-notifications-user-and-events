package controller;

import java.io.*;

public class ArchivesCRUD {
    public static void reader(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader((new FileReader(path)));
        String line = "";
        while (true) {
            if (line != null) {
                System.out.println(line);
            } else break;
            line = buffRead.readLine();
        }
        buffRead.close();
    }

    public static void writer(String path, String infoEvent) throws IOException {
        Writer out;
        out = new BufferedWriter(new FileWriter(path, true));
        out.append(infoEvent);
        out.flush();
        out.close();
    }
}
