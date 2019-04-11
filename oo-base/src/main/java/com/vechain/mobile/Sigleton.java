package com.vechain.mobile;

interface sigletonInterface {

//    public static PublicCountry sharedInstance();
    String code();
}

class PublicCountry implements sigletonInterface {

//    private PublicCountry() { }
//
//    public static PublicCountry sharedInstance {
//        return null;
//    }
//
    public String code() {
        return "PublicCountry";
    }

    /*

    // 饿汉法
    private static PublicCountry country  = new PublicCountry();

    private PublicCountry() {}
    public static sharedInstance(){
        return country;
    }
    */


    /*

    private static final PublicCountry COUNTRY = new PublicCountry();

    private PublicCountry() {

    }

    public static PublicCountry sharedInstance() {
        return COUNTRY;
    }

    public void print() {
        System.out.println("xxxx");
    }

    */
}

class Euro extends PublicCountry implements sigletonInterface {

    private static Euro country = null;
    private Euro() {}

    public static Euro sharedInstance() {
        if (country == null) {
            country = new Euro();
        }
        return country;
    }

    @Override
    public String code() {
        return "Euro";
    }
}

class England extends PublicCountry implements sigletonInterface {

    private static England country;
    private England() {}

    static {
        country = new England();
    }

    public static England sharedInstance() {

        return country;
    }

    @Override
    public String code() {
        return "England";
    }
}

class US extends PublicCountry implements sigletonInterface {

    private static US country;
    private US() {}

    public static synchronized US sharedInstance() {

        if (null == country) {
            country = new US();
        }
        return country;
    }

    @Override
    public String code() {
        return "US";
    }
}

class France extends PublicCountry implements sigletonInterface {

    private static France country;
    private France() {}

    public static France sharedInstance() {

        if (null == country) {
            synchronized (France.class){
                country = new France();
            }
        }
        return country;
    }

    @Override
    public String code() {
        return "France";
    }
}

class German extends PublicCountry implements sigletonInterface {

    private static volatile German country;

    private German() {

    }

    public static German getInstance() {

        if (null == country) {
            synchronized (German.class) {
                if (null == country) {
                    country = new German();
                }
            }
        }
        return country;
    }

    @Override
    public String code() {
        return "German";
    }
}

class Spain extends PublicCountry implements sigletonInterface {

    private Spain country;

    private static class SpainSigleton {
        private static final Spain country = new Spain();
    }

    private Spain() {
    }

    public static Spain sharedInstance() {
        return SpainSigleton.country;
    }

    @Override
    public String code() {
        return "Spain";
    }
}

enum Singapore {
    INSTANCE;
    private String name;
    public String sharedInstance(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String code() {
        return "Singapore";
    }
}



/*
   多种实现收集
http://www.importnew.com/18872.html
*/
public class Sigleton {

    public static void main(String[] args){


        System.out.println(Euro.sharedInstance().code());

        System.out.println(England.sharedInstance().code());

        System.out.println(US.sharedInstance().code());

        System.out.println(France.sharedInstance().code());

        System.out.println(German.getInstance().code());

        System.out.println(Spain.sharedInstance().code());

        System.out.println(Singapore.INSTANCE.code());

    }
}
