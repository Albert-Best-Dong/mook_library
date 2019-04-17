package com.practice.utils;

public class Utils {
    //判断字符串数组有无空
    public static boolean isEmpatyStrings(String []strings) {
        boolean flag = true;
        for (int i = 0; i < strings.length; i++) {
            if(strings[i] == null || strings[i].equals("")||strings[i].trim().equals("")){
                flag =true;
                break;
            }else{
                flag = false;
            }
        }
        return flag;
    }
    public static boolean isEmpatyString(String str){
        if(str==null||str.equals("")||str.trim().equals("")){
            return true;
        }else {
            return false;
        }
    }
    //检验价格是否合法
    public static boolean noValidPrice(String priceString){
        Float price = null;
        try{
            price = Float.parseFloat(priceString);
            if(price<0){
                return false;
            }else{
                System.out.println(price);
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String []strs = {"rtgdtgre","1212"};
        System.out.println(Utils.isEmpatyStrings(strs));
    }
}