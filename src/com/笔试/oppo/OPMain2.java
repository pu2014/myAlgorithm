package com.笔试.oppo;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/29 19:34
 */
public class OPMain2 {
    public static final String path = "d/readme.md";
    public static void readFIle() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), Charset.forName("UTF-8")));
        String str = null;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }
        br.close();
    }
}
