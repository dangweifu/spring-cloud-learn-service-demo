package org.wiulus.spring.cloud.commons.tools.utils;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import org.wiulus.spring.cloud.commons.tools.upload.util.Base64Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片检验工具
 * @Date :2019/5/12 11:15
 * @author ：WiuLuS
 * @Version 1.0
 */
@Slf4j
public class ImageCheckUtils {
    /**
     * @param inputStream
     * @param fileName    文件名称
     * @param uploadDir   上传路径
     * @throws Exception
     */
    public static void resize(InputStream inputStream, String fileName, String uploadDir) throws Exception {
        if (inputStream == null) {
            return;
        }
        BufferedImage src = ImageIO.read(inputStream);
        int old_w = src.getWidth();
        // 得到源图宽
        int old_h = src.getHeight();
        // 得到源图长
        BufferedImage newImg = null;
        // 判断输入图片的类型
        switch (src.getType()) {
            case 13:
                // png,gif
                newImg = new BufferedImage(old_w, old_h, BufferedImage.TYPE_4BYTE_ABGR);
                break;
            default:
                newImg = new BufferedImage(old_w, old_h, BufferedImage.TYPE_INT_RGB);
                break;
        }
        Graphics2D g = newImg.createGraphics();
        // 从原图上取颜色绘制新图
        g.drawImage(src, 0, 0, old_w, old_h, null);
        g.dispose();
        // 根据图片尺寸压缩比得到新图的尺寸
        newImg.getGraphics().drawImage(
                src.getScaledInstance(old_w, old_h, Image.SCALE_SMOOTH), 0, 0, null);
        File newFile = new File(uploadDir + fileName);
        String endName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        ImageIO.write(newImg, endName, newFile);
    }

    /**
     * 上传图片校验
     *
     * @param base64Str
     * @return
     * @Date 2019/8/6 17:13
     * @author WiuLuS
     **/
    public static Map<String, Object> isImage(String base64Str) {
        Map<String, Object> result = new HashMap<>(16);

        try {
            // 限制图片格式
            String imageTypes = "gif,jpg,jpeg,png,bmp,PNG,JEPG,JPG";
            //效验数据
            // 获得图片格式
            String imageType = Base64Util.getFileType(base64Str);

            if (!imageTypes.contains(imageType)) {
                // 判断文件格式
                result.put("code", 400);
                result.put("msg", "图片格式存在问题");
                return result;
            }

            Long picSize = Base64Util.fileSize(base64Str);

            if (picSize > 10485760) {
                // 上传图片不能大于10
                result.put("code", 400);
                result.put("msg", "图片不能大于10M");
                return result;
            }
            result.put("code", 200);
            result.put("imageType", imageType);
            result.put("imageSize", picSize);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "服务器异常");
        }
        return result;
    }

    public static boolean isFile(MultipartFile file) throws IOException {
        boolean flag = true;

        String fileName = file.getOriginalFilename();
        String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
        InputStream inputStream = file.getInputStream();

        Map<String, String> extMap = Maps.newHashMap();
        extMap.put("fileType", "gif,jpg,jpeg,png,bmp,PNG,JEPG,JPG");
        if (!Arrays.<String>asList(extMap.get("fileType").split(",")).contains(extName)) {
            log.error("图片格式存在问题");
            flag = false;
        }
        long size = file.getSize();
        if (size > 10485760) {
            log.error("图片不能大于 10M");
            flag = false;
        }
        return flag;
    }

    /**
     * 将byte[]转换为十六进制字符串
     *
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 第三种
     * 通过读取文件并获取其width及height的方式，来判断判断当前文件是否图片
     *
     * @param imageFile 上传文件的路径
     * @return
     */
    public static boolean isImage(File imageFile) {
        if (!imageFile.exists()) {
            return false;
        }
        Image img = null;
        try {
            img = ImageIO.read(imageFile);
            if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            img = null;
        }
    }


}
