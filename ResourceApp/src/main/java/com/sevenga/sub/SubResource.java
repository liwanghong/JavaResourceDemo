package com.sevenga.sub;

import java.io.InputStream;

public class SubResource {
    public void loadResource()
    {
        byte[] bytes = new byte[1024];
        try {
            InputStream packageResStream = getClass().getResourceAsStream("packageRes.txt");

            int length = packageResStream.read(bytes);
            packageResStream.close();
            System.out.println("SubResource package" + new String(bytes,0, length, "UTF-8"));
        }
        catch (Exception e) {
            System.out.println("SubResource package failed");
        }

        try {
            InputStream resUrlStream = getClass().getResourceAsStream("/resourceRes.txt");
            int length = resUrlStream.read(bytes);
            resUrlStream.close();
            System.out.println("SubResource res" + new String(bytes,0, length,"UTF-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream packageResStream = getClass().getResourceAsStream("/com/sevenga/packageRes.txt");

            int length = packageResStream.read(bytes);
            packageResStream.close();
            System.out.println("SubResource absolute package" + new String(bytes,0, length, "UTF-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
