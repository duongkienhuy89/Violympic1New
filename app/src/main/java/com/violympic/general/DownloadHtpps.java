package com.violympic.general;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class DownloadHtpps {
    private static final int BUFFER_SIZE = 4096;

    /**
     * Downloads a file from a URL
     * @param fileURL HTTP URL of the file to be downloaded
     * @param saveDir path of the directory to save the file
     * @throws IOException
     */
    public static void downloadFile(String fileURL, String saveDir,String pNameFile)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();

            if(pNameFile.equals("")) {
                if (disposition != null) {
                    // extracts file name from header field
                    int index = disposition.indexOf("filename=");
                    if (index > 0) {
                        fileName = disposition.substring(index + 10,
                                disposition.length() - 1);
                    }
                } else {
                    // extracts file name from URL
                    fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                            fileURL.length());
                }
            }else
            {
                fileName=pNameFile;
            }

//            System.out.println("Content-Type = " + contentType);
//            System.out.println("Content-Disposition = " + disposition);
//            System.out.println("Content-Length = " + contentLength);
//            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            // Log.e("tuvi","File downloaded:"+fileName);
        } else {
            // Log.e("tuvi","No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
    public static void downloadFileDataBlog(String fileURL, String saveDir,String pNameFile)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");


            if(pNameFile.equals("")) {
                if (disposition != null) {
                    // extracts file name from header field
                    int index = disposition.indexOf("filename=");
                    if (index > 0) {
                        fileName = disposition.substring(index + 10,
                                disposition.length() - 1);
                    }
                } else {
                    // extracts file name from URL
                    fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                            fileURL.length());
                }
            }else
            {
                fileName=pNameFile;
            }
            InputStream inputStream = httpConn.getInputStream();
            File fileBlog = new File(saveDir + File.separator, fileName);
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, bytesRead);
            }
            FileOutputStream stream = new FileOutputStream(fileBlog);
            try {
                stream.write(doPaseQuestion(result.toString("UTF-8").
                        replace("&nbsp;","").
                        replace("&ensp;","").
                        replace("&emsp;","").
                        replace("&8194;","").
                        replace("&8195;","").
                        replace("&quot;","'").
                        replace("&#8220;","'").
                        replace("&#8221;","'").
                        replace("&#8222;","'").
                        replace("&#8242;","'").
                        replace("&#8243;","'").
                        replace("&#8254;","-").
                        replace("&#8230;","..."))
                        .getBytes());
            } finally {
                stream.close();
            }
            inputStream.close();

        } else {
            // Log.e("tuvi","No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
    public static String doPaseQuestion(String pInput)
    {
        if(pInput.contains("balo1"))
        {
            return pInput.substring(pInput.indexOf("balo1", pInput.indexOf("balo1") + 1)+4,pInput.indexOf("}balo")+1);
        }
        return "";
    }
}
