package com.zj.sword2offer;

/**
 * Created on 2020/12/3.
 */

class BigNumberCalculation {
  /**
   * 大数相乘
   */
  public void bigMultiply(String num1, String num2) {
    int[] i1 = new int[num1.length()];
    int[] i2 = new int[num2.length()];
    int[] result = new int[num1.length() + num2.length()];
    for (int i = 0; i < i1.length; i++) {
      i1[i] = num1.charAt(i) - '0';
    }
    for (int i = 0; i < i2.length; i++) {
      i2[i] = num2.charAt(i) - '0';
    }
    for (int i = 0; i < i1.length; i++) {
      for (int j = 0; j < i2.length; j++) {
        result[i + j] += i1[i] * i2[j];
      }
    }
    for (int i = result.length - 1; i > 0; i--) {
      result[i - 1] += result[i] / 10;
      result[i] = result[i] % 10;
    }
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < result.length; i++) {
      sb.append(result[i]);
    }
  }

  /**
   * 两个大正数相除
   * @param num1
   * @param num2
   * @return
   */
  public static String bigPositiveDiv(String num1,String num2) {
    String result = "";
    int len = num1.length() - num2.length();
    //num1 < num2
    if (len < 0) {
      result = "0";
    }else if (len == 0 && compare(num1, num2)==0) {
      result = "1";
    }else {
      //主要处理num1 》 num2的情况
      while (len > 0) {
        //除数补零操作
        while(num1.length() > num2.length()){
          num2 = num2 + "0";
        }
        if (compare(num1, num2) < 0) {
          num1 = num1 + "0";
        }

        //处理补零操作后被除数和除数相等的情况，如果相等，则最高位为1，其后补被除数和除数长度之差，即len个零；
        if (compare(num1, num2) == 0 && result.equals("")) {
          result = "1";
        }

        for (int i = 9; i > 0; i--) {
          String mulr = multiply(num2, String.valueOf(i));
          if (compare(mulr,num1) < 0) {
            num1 = subPositiveNum(num1, mulr);
            result += i;
            i = 0;
          }
          if (i == 1) {
            result += "0";
          }
        }
        len--;
      }
    }

    System.out.println(result);
    return result;
  }

  /**
   * 比较两个大正数字符串值得大小
   * @param data1
   * @param data2
   * @return
   */
  public static int compare(String data1,String data2){
    if (data1.length() < data2.length()) {
      return -1;
    }else if (data1.length() > data2.length()) {
      return 1;
    }else{
      if (data1.compareTo(data2) > 0) {
        return 1;
      }else if(data1.compareTo(data2) < 0){
        return -1;
      }else {
        return 0;
      }
    }
  }

  /**
   * 两个相乘
   * @param str1
   * @param str2
   * @return
   */
  public static String multiply(String str1,String str2) {
    //2.加减乘除方法前都会计算这几个参数
    int len1 = str1.length();
    int len2 = str2.length();
    char[] ch1 = str1.toCharArray();
    char[] ch2 = str2.toCharArray();
    //1.构造各位乘数的二维数组
    int[][] temp = new int[len1][len2];
    for (int i = 0; i < len1; i++) {
      for (int j = 0; j < len2; j++) {
        int c1 = Integer.parseInt(String.valueOf(ch1[i]));
        int c2 = Integer.parseInt(String.valueOf(ch2[j]));
        temp[i][j] = c1*c2;
      }
    }

    //2.计算算术和，不考虑进位
    int[] r = new int[len1+len2-1];   //保存错位相加的数字
    for (int k = 0; k < r.length; k++) {
      for (int i = 0; i < len1; i++) {
        for (int j = 0; j < len2; j++) {
          if (i+j == k) {   //重点：和计算条件
            r[k] += temp[i][j];
          }
        }
      }
    }

    //处理进位问题：保留各位，十位进位相加
    for (int k = r.length-1; k > 0; k--) {
      if (r[k] > 9) {
        r[k-1] = r[k]/10+r[k-1];
        r[k] = r[k]%10;
      }
    }
    StringBuffer str = new StringBuffer();
    for (int k = 0; k < r.length; k++) {
      str.append(r[k]);
    }

    return str.toString();
  }

  /**
   * 两个正整数相减，且num1>num2
   * @param num1
   * @param num2
   * @return
   */
  public static String subPositiveNum(String num1,String num2) {
    int tag = 0;
    int sub = 0;
    StringBuffer str = new StringBuffer(" ");
    int i = num1.length()-1;
    int j = num2.length()-1;
    while (i >= 0 && j >= 0) {
      sub = (num1.charAt(i) - '0')-(num2.charAt(j)-'0')+tag;
      if (sub < 0) {
        tag = -1;
        sub = 10 + sub;
      }else {
        tag = 0;
      }
      str.insert(1, sub);
      i--;j--;
    }

    while (i > 0) {
      if (tag < 0) {
        sub = (num1.charAt(i) - '0')+tag;
        if (sub < 0) {
          tag = -1;
          sub = sub + 10;
        }else {
          tag = 0;
        }
        str.insert(1, sub);
        i--;
      } else {
        sub = num1.charAt(i) - '0';
        str.insert(1, sub);
        i--;
      }
    }
    System.out.println("sub"+str);
    return str.toString().trim();
  }
}
