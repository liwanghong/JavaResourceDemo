package com.sevenga;

import com.sevenga.sub.SubResource;

import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

public class ResourceApp {

    public void loadResource()
    {
        byte[] bytes = new byte[1024];
        try {
            InputStream packageResStream = getClass().getResourceAsStream("packageRes.txt");

            int length = packageResStream.read(bytes);
            packageResStream.close();
            System.out.println("ResourceApp package" + new String(bytes,0, length, "UTF-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream resUrlStream = getClass().getResourceAsStream("/resourceRes.txt");
            int length = resUrlStream.read(bytes);
            resUrlStream.close();
            System.out.println("ResourceApp res" + new String(bytes,0, length,"UTF-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Enumeration<URL> urls = getClass().getClassLoader().getResources("com/sevenga/packageRes.txt");
            while (urls.hasMoreElements())
            {
                URL url = urls.nextElement();
                InputStream urlStream = url.openStream();
                int length = urlStream.read(bytes);
                System.out.println("ResourceApp get all match packageRes" + new String(bytes,0, length,"UTF-8"));
                urlStream.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
            InputStream package1OnyResStream = getClass().getResourceAsStream("/com/sevenga/Resource1.txt");
            int length = package1OnyResStream.read(bytes);
            package1OnyResStream.close();
            System.out.println("ResourceApp Resource1Only package" + new String(bytes,0, length,"UTF-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream package1OnyResStream = getClass().getResourceAsStream("/com/sevenga/Resource2.txt");
            int length = package1OnyResStream.read(bytes);
            package1OnyResStream.close();
            System.out.println("ResourceApp Resource2Only package" + new String(bytes,0, length,"UTF-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Resource1 resource1 = new Resource1();
        resource1.loadResource();

        Resource2 resource2 = new Resource2();
        resource2.loadResource();

        ResourceApp resourceApp = new ResourceApp();
        resourceApp.loadResource();

        SubResource subResource = new SubResource();
        subResource.loadResource();
    }
}
