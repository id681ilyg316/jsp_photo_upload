package org.njy.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class ConvertUtil {
	private static ConvertUtil convert = null;

	private ConvertUtil() {
	}

	public static ConvertUtil getInstance() {
		if(convert==null){
			convert = new ConvertUtil();
		}
		return convert;
	}

	/**
	 * �÷����������ַ���ת����int
	 * 
	 * @param Ҫת����int���ַ���
	 * @return ת�����intֵ
	 */
	public int strToInt(String str) {
		int i = 0;
		try {
			if (str != null) {
				i = Integer.parseInt(str);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();

		}
		return i;
	}

	/**
	 * ��ʽ��ʱ��
	 * 
	 * @return ���ص�ǰ��ʱ���ʽΪ��2008-07-27 13:01:20
	 */
	public String getTime() {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simple.format(new Date());
		return date;
	}

	/**
	 * ��ȡ�ַ���(ͨ����ͼƬ��path�õ���ͼƬ��·��)
	 */
	public static String substring(Object str) {
		return str.toString().replace("_min.", ".");

	}

	/**
	 * �÷������������û������Html����
	 * 
	 * @param str
	 * @return
	 */
	public String filterHtml(String str) {
		if (null == str)
			return null;
		char c[] = str.toCharArray();
		StringBuffer buf = new StringBuffer();
		for (int i = 0, size = c.length; i < size; i++) {
			char ch = c[i];
			if (ch == '"') {
				buf.append("&quot;");
			} else if (ch == '&') {
				buf.append("&amp;");
			} else if (ch == '<') {
				buf.append("&lt;");
			} else if (ch == '>') {
				buf.append("&gt;");
			} else if (ch == '\n') {
				buf.append("<br>");
			} else if (ch == ' ') {
				buf.append("&nbsp;");
			} else if (ch == '\\') {
				buf.append("&#92");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}
	
	 public static void mark(String srcImgPath, String outImgPath, Color markContentColor, String waterMarkContent) {
	        try {
	            // ��ȡԭͼƬ��Ϣ
	            File srcImgFile = new File(srcImgPath);
	            Image srcImg = ImageIO.read(srcImgFile);
	            int srcImgWidth = srcImg.getWidth(null);
	            int srcImgHeight = srcImg.getHeight(null);
	            // ��ˮӡ
	            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
	            Graphics2D g = bufImg.createGraphics();
	            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
	            // Font font = new Font("Courier New", Font.PLAIN, 12);
	            Font font = new Font("����", Font.PLAIN, 20);
	            g.setColor(markContentColor); // ����ͼƬ�ı�������ˮӡ��ɫ

	            g.setFont(font);
	            int x = srcImgWidth - getWatermarkLength(waterMarkContent, g) - 3;
	            int y = srcImgHeight - 3;
	            // int x = (srcImgWidth - getWatermarkLength(watermarkStr, g)) / 2;
	            // int y = srcImgHeight / 2;
	            g.drawString(waterMarkContent, x, y);
	            g.dispose();
	            // ���ͼƬ
	            FileOutputStream outImgStream = new FileOutputStream(outImgPath);
	            ImageIO.write(bufImg, "jpg", outImgStream);
	            outImgStream.flush();
	            outImgStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * ��ȡˮӡ�����ܳ���
	     * 
	     * @param waterMarkContent
	     *            ˮӡ������
	     * @param g
	     * @return ˮӡ�����ܳ���
	     */
	    public static int getWatermarkLength(String waterMarkContent, Graphics2D g) {
	        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
	    }

	/**
	 * ���Թ������з�������ȷ��
	 * 
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ConvertUtil conv = new ConvertUtil();
	}
}
