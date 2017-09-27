package cn.imaq.java9demo;

import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.BufferedImage;
import java.awt.image.MultiResolutionImage;

public class MultiResolutionImageDemo {
    public static void main(String[] args) {
        MultiResolutionImage multiResolutionImage = new BaseMultiResolutionImage(
                new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB),
                new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB),
                new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB)
        );
        System.out.println(multiResolutionImage.getResolutionVariant(50, 50));
        System.out.println(multiResolutionImage.getResolutionVariant(150, 150));
        System.out.println(multiResolutionImage.getResolutionVariant(1000, 1000));
    }
}
