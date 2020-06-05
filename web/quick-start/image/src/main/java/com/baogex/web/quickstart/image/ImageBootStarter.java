package com.baogex.web.quickstart.image;


import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageBootStarter {

    public static void main(String[] args) throws IOException {
        //  Thumbnails.of("f:/1.png").scale(0.3).toFile("f:/2.png");
        Thumbnails.of("f:/pangzi.png").scale(0.5).toFile("f:/shouzi.png");

        // Thumbnails.of("f:/2.png").size(1400,400).toFile("f:/3.png");
    }

    public static String imgConvert(String tempDirPath, String fileName, String fileExt) throws IOException {
        String srcPath = tempDirPath + fileName;  //原始图片路径
        if ("png".equals(fileExt)) {

            //生成新图片名称
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String fileString = df.format(new Date()) + "_" + new Random().nextInt(1000) + ".jpg";

            //新图片全路径
            String newJpg = tempDirPath + fileString;

            // 1、先转换成jpg
            Thumbnails.of(srcPath).scale(1f).toFile(newJpg);

            //2.jpg图片压缩
            Thumbnails.of(newJpg).scale(1f).outputQuality(0.25d).toFile(newJpg);

            //压缩成功后,删除png图片
            File f = new File(srcPath);
            f.delete();

            return fileString;
        } else {
            Thumbnails.of(srcPath).scale(1f).outputQuality(0.25d).toFile(srcPath);
        }
        return null;
    }
}
