package com.node3.cn.util;
 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
 
/**
 * 将文件夹下面的文件
 * 打包成zip压缩文件
 * 
 * @author admin
 *
 */
public final class FileToZip {

	private FileToZip(){}
	
	/**
	 * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
	 * @param sourceFilePath :待压缩的文件路径
	 * @param zipFilePath :压缩后存放路径
	 * @param fileName :压缩后文件的名称
	 * @return
	 */
	public static void fileToZip(List<File> files,String zipFile_absolute_path){
		boolean flag = false; 
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		 
		if(files != null && files.size() > 0){ 
			try {
				File zipFile = new File(zipFile_absolute_path);
				// 新增校验父目录是否存在
				File parent = zipFile.getParentFile(); 
		        if(parent!=null&&!parent.exists()){ 
		        	parent.mkdirs(); 
		        }
				String fileName = zipFile.getName();
				if(zipFile.exists()){
					System.out.println(  "目录下存在名字为:" + zipFile_absolute_path +"打包文件.");
//					//判断打包文件是否存在，如果存在就删除
//					if(zipFile.exists()) {  
//						zipFile.delete();
//					}
				}else{ 
						fos = new FileOutputStream(zipFile);
						zos = new ZipOutputStream(new BufferedOutputStream(fos) );

						zos.setEncoding("UTF-8");

						byte[] bufs = new byte[1024*10];
						for(int i=0;i<files.size();i++){
							//创建ZIP实体，并添加进压缩包
							ZipEntry zipEntry = new ZipEntry(files.get(i).getName());
							zos.putNextEntry(zipEntry);
							//读取待压缩的文件并写进压缩包里
							fis = new FileInputStream(files.get(i));
							bis = new BufferedInputStream(fis, 1024*10);
							int read = 0;
							while((read=bis.read(bufs, 0, 1024*10)) != -1){
								zos.write(bufs,0,read);
							}
						}
						flag = true; 
				 
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally{
				//关闭流
				try {
					if(null != bis) bis.close();
					if(null != zos) zos.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		
			
			
		}else{
			System.out.println("待压缩的文件里面不存在文件，无需压缩.");
			 
		}
		if(flag){
			System.out.println("文件打包成功!");
		}else{
			System.out.println("文件打包失败!");
		}
	 
	}
	
	public static void main(String[] args){
		String sourceFilePath = "D:\\TestFile";
		String zipFilePath = "D:\\tmp";
		String fileName = "12700153file";
//		boolean flag = FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName);
//		if(flag){
//			System.out.println("文件打包成功!");
//		}else{
//			System.out.println("文件打包失败!");
//		}
	}
	
}
 
