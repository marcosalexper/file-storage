package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private File storageDir;

    public FileService(String dirPath) {
        storageDir = new File(dirPath);
        if (!storageDir.exists()) {
            storageDir.mkdirs();
        }
    }

    public void storeFile(String username, File file) throws IOException {
        File userDir = new File(storageDir, username);
        if (!userDir.exists()) {
            userDir.mkdirs();
        }

        File destFile = new File(userDir, file.getName());
        try (InputStream in = new FileInputStream(file);
             OutputStream out = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    public List<String> listFiles(String username) {
        File userDir = new File(storageDir, username);
        if (!userDir.exists()) {
            return new ArrayList<>();
        }

        String[] files = userDir.list();
        if (files == null) {
            return new ArrayList<>();
        }

        List<String> fileList = new ArrayList<>();
        for (String file : files) {
            fileList.add(file);
        }
        return fileList;
    }
}
    

