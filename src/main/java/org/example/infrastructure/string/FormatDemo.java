package org.example.infrastructure.string;

import java.util.StringJoiner;

/**
 * @description: 格式化字符串示例
 * @Author shengy
 * @Date 2025/2/17 10:42
 */
public class FormatDemo {
  public static void main(String[] args) {
    format1();
  }

  /**
   * 将ac,ab,cc格式字符串转为["ac","ab","cc"]
   */
  public static void format1() {
    String str = "iPhone15ProMax,iPhone15Pro,iPhone15Plus,iPhone15,iPhone16ProMax,iPhone16Pro,iPhone16,iPhone16Plus,iPhone14Pro,iPhone14ProMax,iPhone14,iPhone14Plus,iphone13,iPhone13ProMax,iPhone13Pro,iPhone13mini,iPhone12,iPhone12ProMax,iPhone12Pro,iPhone12mini,iPhone11,iPhone11ProMax,iPhone11Pro,iPhoneXR,iPhoneXsMax,iPhoneXS,AppleWATCHSeries10,AppleWATCHSeries9,AppleWATCHSeries7,AppleWATCHSeries8,AppleWATCHSeries3,AppleWATCHSeries4,AppleWATCHSeries6,AppleWATCHSeries5,iPhoneSE第2代,iPhoneSE第3代,iPhoneSE,iPhoneSE2,iPhoneSE3,AppleWATCHUltra2,AppleWATCHUltra,AppleWatchSE,iPad第6代,iPad第5代,iPad第3代,iPadmini6,iPadmini4,iPadPro第4代,iPadPro第6代,iPadPro第5代,iPadAir2,iPadAir5,AppleWATCH第5代,iPhoneX,华为Mate60Pro,华为Mate60,华为Mate30Pro,华为Mate40Pro,华为MateX5,华为Mate30,华为Mate60Pro+,华为Mate20Pro,华为Mate50Pro,华为Mate10Pro,华为Mate20,华为Mate50,华为Mate40,华为Mate40E,华为Mate20X,华为MateX3,华为MateX2,华为Mate9,华为Mate30EPro,华为Mate40Pro+,华为Mate10,华为Mate50E,华为MateX2典藏版,华为MatePadPro,华为MatePadSE,华为MateXs,华为Mate9Pro,华为Mate40EPro,华为MatePad,华为Mate30RS,华为MateRS,华为Mate7,华为MatePadPro2,华为MatePadAir,华为Mate10Lite,华为MateXs2,华为MateX,华为Mate2,华为Pura70,华为Pura70Pro,华为Pura70Pro+,华为Pura70Ultra,华为Nova12Pro,华为Nova12活力版,华为Nova7,华为Nova12SE,华为Nova7SE,华为Nova7Pro,华为Nova11SE,华为Nova5Pro,华为Nova8,华为Nova12,华为Nova10,华为Nova3,华为Nova9SE,华为NovaFlip,华为Nova9,华为Nova4,华为Nova6,华为Nova5i,华为Nova12Ultra,华为Nova8Pro,华为Nova11,华为Nova10SE,华为Nova8SE,华为Nova4e,华为Nova12Ultra星耀版,华为Nova5iPro,华为Nova9Pro,华为Nova3i,华为Nova10Pro,华为Nova13Pro,华为Nova6SE,华为Nova2s,华为Nova11Pro,华为Nova7SE乐活版,华为Nova3e,华为Nova10z,华为Nova7SE活力版,华为Nova2Plus,华为Nova11Ultra,华为Nova2,华为Nova青春版,华为Nova5T,华为NovaY70,华为Nova7i,华为NovaY90,华为Nova8i,华为畅享70Pro,华为畅享70S,华为畅享60X,华为畅享70,华为畅享10,华为畅享9,华为畅享9Plus,华为畅享60,华为畅享10e,华为畅享10Plus,华为畅享20Pro,华为畅享10S,华为畅享50,华为畅享8,华为畅享20e,华为畅享20Plus,华为畅享60Pro,华为畅享20SE,华为畅享9S,华为畅享20,华为畅享50Pro,华为畅享9e,华为畅享8Plus,华为畅享50z,华为畅享Max,华为畅享Z,华为畅享8e青春版,华为畅享8e,华为畅享7Plus,华为畅享7,华为畅享6,华为畅享6S,华为畅享7S,华为P40,华为P30Pro,华为P50Pro,华为P30,华为P40Pro,华为P60,华为P20Pro,华为P20,华为P50E,华为P50,华为PocketS,华为P50Pocket,华为P10,华为P9,华为P10Plus,华为P30Lite,华为P20Lite,华为P40Lite,华为P9Plus,华为P50LiteE,华为P40Pro+,华为PSmart2019,华为P8Max,华为P8Lite,荣耀畅玩40Plus,荣耀畅玩20,荣耀Play5T,荣耀Play4T,荣耀Play6C,荣耀Play5,荣耀畅玩9A,华为儿童手表5活力版,华为儿童手表4Pro,华为儿童手表5Pro,华为儿童手表5XPro,华为儿童手表4X,华为Mate10RS,华为儿童手表,荣耀80GT,荣耀50Pro,荣耀80SE,荣耀80Pro,华为麦芒10SE,华为麦芒9,华为麦芒7,华为麦芒8,华为麦芒6,华为WATCH4Pro,华为WATCH4,华为WATCH3Pro,华为WATCH3Pronew,华为WATCH3,华为WATCH2,荣耀9X,华为平板M6,华为平板C5,华为平板M5青春版,华为擎云C5第二代,华为平板电脑C5,华为畅玩平板2,华为畅享平板,华为畅享平板2,华为平板M5,华为平板M3青春版,华为平板M3,华为揽阅M2青春版,华为平板C3,华为M5青春版,华为平板M5Pro,华为MediaPadM2,荣耀MagicVs,荣耀MagicV,荣耀MagicVs至臻版,华为随行WiFi2mini,华为随行WiFi3,华为随行WiFi,华为EP631S,荣耀平板V7Pro,荣耀平板7,荣耀平板5,荣耀平板V6,荣耀平板6,荣耀平板X6,华为Y6,华为Y9s,华为Y92019,华为Y9A,华为Y6S,华为Nexus6P,华为鼎桥EP681,华为B311As853,华为4G路由2Pro,华为B310As852,华为AscendG630,华为G7,华为G5000,华为ETS5623,华为F516,华为F362,华为F501,华为F317,华为ETS312A,华为FP515H,华为F566,华为ETS3125,华为F560,华为F561,华为ETS315M";
    String[] split = str.split(",");
    StringBuilder sb = new StringBuilder();
    StringJoiner stringJoiner = new StringJoiner(",");
    for (String s : split) {
      stringJoiner.add("\"" + s + "\"");
    }
    System.out.println("[" + stringJoiner + "]");
  }
}
