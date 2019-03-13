package com.uniqolabel.uniqolabelapp.compression;

/**
 * Created by androiddev on 05-03-2018.
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPCompression {
    public static byte[] compress(final String str) throws IOException {
        if ((str == null) || (str.length() == 0)) {
            return null;
        }
        ByteArrayOutputStream obj = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(obj);
        gzip.write(str.getBytes("UTF-8"));
        gzip.flush();
        gzip.close();
        return obj.toByteArray();
    }

    public static String decompress(final byte[] compressed) throws IOException {
        final StringBuilder outStr = new StringBuilder();
        if ((compressed == null) || (compressed.length == 0)) {
            return "";
        }
        if (isCompressed(compressed)) {
            final GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outStr.append(line);
                outStr.append(" ");
            }
        } else {
            outStr.append(compressed);
        }

        String intermString = outStr.toString();
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < intermString.length(); i++) {
            if (i % 2 == 0) {
                if (intermString.charAt(i) != ' ')
                    finalString.append(intermString.charAt(i) + "");
            }
        }
        return finalString.toString();
    }

    public static boolean isCompressed(final byte[] compressed) {
        return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
    }
}