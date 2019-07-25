package com.xiaokunliu.common.file;

import java.io.File;

/**
 * Created by keithl on 2017/7/27.
 */

public final class FilesUtility {

    public static boolean isResourceExistOnLocalPath(String localPath){
       try{
           File file = new File(localPath);
           return (file.exists() && file.isFile());
       }catch (Exception e){}
        return false;
    }
}
