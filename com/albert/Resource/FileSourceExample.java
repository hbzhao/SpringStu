package SpringStu.com.albert.Resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileSourceExample {
    public static void main(String[] args){
        try{
            String filePath="G:\\JetbrainsPrj\\Intellij\\untitled\\src\\file1.txt";
            WritableResource res1=new PathResource(filePath);
            OutputStream stream1=res1.getOutputStream();
            stream1.write("this is my first try".getBytes());
            stream1.close();
            InputStream ins1=res1.getInputStream();
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            int i;
            while ((i=ins1.read())!=-1){
                baos.write(i);
            }
            System.out.println(baos.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
