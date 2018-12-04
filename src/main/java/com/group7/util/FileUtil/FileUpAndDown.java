package com.group7.util.FileUtil;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.UUID;


/**
 * ClassName:FileUpAndDown
 * Description:
 * Ftp上传服务器的步骤：
 * 第一步，创建一个客户端对象，
 * 第二步，连接服务器，地址，端口，
 * 第三步，实现登录信息，用户名，密码
 * 第四步，创建上传的文件文件夹 同时创建上传路径
 * 第五步，指定ftp上传路径
 * 第六步，指定上传文件类型为二进制类型
 * 第七步，读取要上传的本地文件路径，同时创建输入流
 * 第八步，用客户端上传本地文件，参数设置文件名跟输入流
 * 第九步，处理异常，关闭文件流，断开服务器连接。
 * Author:严浩天
 * CreateTime:2018-11-29 15:07
 */
@Component
public class FileUpAndDown{
    //私有构造
    private FileUpAndDown(){};
    //私有静态属性
    private static FileUpAndDown fileUpAndDown;
    //懒汉模式
    public static FileUpAndDown getInstance(){
        if(fileUpAndDown==null){
            fileUpAndDown = new FileUpAndDown();
        }
        return fileUpAndDown;
    }

    @Value("${remoteIp}")
    private String remoteIp;

    @Value("${uploadPort}")
    private int uploadPort;

    @Value("${ftpUserName}")
    private  String ftpUserName;

    @Value("${ftpPassWord}")
    private  String ftpPassWord;

    @Value("${remotePath}")
    private  String remotePath;

    /**
     * 将图片上传到ftp远程服务器
     */
    public String upLoad(MultipartFile multipartFile){
        //创建客户端对象
        FTPClient ftp = new FTPClient();
        InputStream local = null;
        String newFileName = null;
        try {
            //连接ftp服务器
            ftp.connect("39.96.8.65",21);
            //登录
            ftp.login("ftpadmin","yanhaotian");
            //设置上传路径
            String path = "/home/ftpadmin/images";
            //检查上传路径是否存在 如果不存在返回false
            boolean flag = ftp.changeWorkingDirectory(path);
            if(!flag){
                //创建上传的路径 该方法只能创建一级目录,在这里如果/home/ftpadmin存在则可以创建image
                ftp.makeDirectory(path);
            }
            //指定上传路径
            ftp.changeWorkingDirectory(path);
            //指定上传文件的类型 二进制文件
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

           // MultipartFile multipartFile=null;
            //获取文件的绝对路径
            //String absolutePath = multipartFile.getResource().getFile().getAbsolutePath();
            //System.out.println(absolutePath+"绝对路径。。。。。。。。。。。");

            String originalFilename = multipartFile.getOriginalFilename();
            newFileName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
            //读取本地文件
            File file =new File("E:/localftp"+File.separator+newFileName);
            //multipartFile.transferTo(file);
            org.apache.commons.io.FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),file);
            System.out.println(file.length()+"............");
            local = new FileInputStream(file);
            //第一个参数是文件名
            ftp.storeFile(file.getName(),local);
        }catch (SocketException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //关闭文件流
                if(local!=null)
                local.close();
                //退出
                if(ftp!=null) {
                    ftp.logout();
                    //断开连接
                    ftp.disconnect();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }//finally
        System.out.println(newFileName+"图片的名字");
        return newFileName;
    }
}

