package com.sevenga;

import java.io.InputStream;
import java.net.URL;

public class Resource1 {
    public void loadResource() {
        byte[] bytes = new byte[1024];
        try {
            InputStream packageResStream = getClass().getResourceAsStream("packageRes.txt");

            int length = packageResStream.read(bytes);
            packageResStream.close();
            System.out.println("Resource1 package" + new String(bytes,0, length, "UTF-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream resUrlStream = getClass().getResourceAsStream("/resourceRes.txt");
            int length = resUrlStream.read(bytes);
            resUrlStream.close();
            System.out.println("Resource1 res" + new String(bytes,0, length,"UTF-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream package1OnyResStream = getClass().getResourceAsStream("/com/sevenga/Resource1.txt");
            int length = package1OnyResStream.read(bytes);
            package1OnyResStream.close();
            System.out.println("Resource1Only package" + new String(bytes,0, length,"UTF-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream classLoaderStream = getClass().getClassLoader().getResourceAsStream("com/sevenga/packageRes.txt");
            int length = classLoaderStream.read(bytes);
            classLoaderStream.close();
            System.out.println("Resource1 classloader package" + new String(bytes,0, length,"UTF-8"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Explain reference https://stackoverflow.com/questions/32215693/classloader-resource-paths-are-always-absolute
        try {
            InputStream classLoaderStream = getClass().getClassLoader().getResourceAsStream("/resourceRes.txt");
            int length = classLoaderStream.read(bytes);
            classLoaderStream.close();
            System.out.println("Resource1 classloader absolute package" + new String(bytes,0, length,"UTF-8"));
        }
        catch (Exception e)
        {
            System.out.println("Resource1 classloader absolute failed");
            //e.printStackTrace();
        }
    }
}
