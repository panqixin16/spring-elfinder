package cn.kong.web.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//列出File的一些常用的操作（过滤，遍历...）
public class FileUtils {
	
	 /*
    列出指定目录下（包括子目录）的所有文件,返回相对路径
     */
	public static FileInfo listDirectorywithRelativePath(String dirPath) throws IOException{
		return listDirectory(new File(dirPath), dirPath);
	}
	
	 /*
    列出指定目录下（包括子目录）的所有文件,返回绝对路径
     */
	public static FileInfo listDirectorywithAbsolutepath(String dirPath) throws IOException{
		return listDirectory(new File(dirPath));
	}
	
	 /*
    列出指定目录下（包括子目录）的所有文件,返回绝对路径
     */
	public static FileInfo listDirectory(File dir) throws IOException{
		return listDirectory(dir, "");
	}
	
    /*
    列出指定目录下（包括子目录）的所有文件，返回相对路径
     */
    public static FileInfo listDirectory(File dir, String rootPath)throws IOException{
        if(!dir.exists()){
            throw new IllegalArgumentException("目录："+dir+"不存在");
        }
        //判断是否是目录
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录");
        }
        //list（）方法用于列出当前目录下子目录和文件
//        String[] filename = dir.list();//返回的是字符串数组（不包含子目录下的内容）
//        for(String string:filename){
//            System.out.println(dir+string);
//        }
       
        List<FileInfo> children = new ArrayList<>();
        List<FileInfo> dirs = new ArrayList<>();
        List<FileInfo> files = new ArrayList<>();
        //如果要遍历子目录的子目录就需要构造成file对象进行递归操作，File提供了直接返回File对象的API
        File[] filename2 = dir.listFiles();//返回的是直接子目录（文件）的抽象
        System.out.println(filename2);
        if(filename2!=null&&filename2.length>0){
            for(File file:filename2){
                if(file.isDirectory()){                	
                    //递归
                    dirs.add(listDirectory(file, rootPath));
                }else {
                    files.add(new FileInfo("File", file.getName(), file.getAbsolutePath(), null, rootPath));
                }
            }
        }
        children.addAll(dirs);
        children.addAll(files);
        return new FileInfo("directory", dir.getName(), dir.getAbsolutePath(), children, rootPath);
    }
    
   
}

