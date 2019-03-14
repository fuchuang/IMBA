package com.IMBA.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class QRCodeUtil {

    private static final int width=300;

    private static final int height=300;

    private static final String format="png";

    //二维码参数
    private static final Map<EncodeHintType, Object> hints = new HashMap();

    static {
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// 字符编码
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);// 容错等级 L、M、Q、H 其中 L 为最低, H 为最高
        hints.put(EncodeHintType.MARGIN, 0);// 二维码与图片边距
    }

    /**
     * 返回一个 BufferedImage 对象
     * @param object 课程信息
     */

    public static BufferedImage createQRCode(String object) throws WriterException {
        BitMatrix bitMatrix=new MultiFormatWriter().encode(String.valueOf(object), BarcodeFormat.QR_CODE, width, height, hints);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    /**
     * 将二维码图片输出到一个流中
     * @param object 课程信息
     * @param stream  输出流
     */
    public static void writeToStream(String object, OutputStream stream) throws WriterException, IOException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(String.valueOf(object), BarcodeFormat.QR_CODE, width, height, hints);
        MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
    }
}
