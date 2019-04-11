package com.vechain.mobile;

//interface Currency {
//
//    public String symbol();
//
//    public String code();
//}
//
//enum Country {
//    US , Spain , UK , Greece , China;
//}
//
//class Euro implements Currency {
//
//    @Override
//    public String code() {
//        return "ERU";
//    }
//    @Override
//    public String symbol() {
//        return "€";
//    }
//
//}
//
//class USDolar implements Currency {
//
//    @Override
//    public String code() {
//        return "USD";
//    }
//
//    @Override
//    public String symbol() {
//        return "$";
//    }
//}
//
//class RMB implements Currency {
//
//    @Override
//    public String code() {
//        return "RMB";
//    }
//
//    @Override
//    public String symbol() {
//        return "¥";
//    }
//}

//public class factory {
//
//    public static Currency currencyForCountry(Country country) {
//        switch (country) {
//            case UK:
//            case Spain:
//            case Greece:
//                return new Euro();
//            case US:
//                return new USDolar();
//            case China:
//                return new RMB();
//            default:
//                return null;
//        }
//    }
//
//    public static void main(String[] args) {
//
//        factory cashFactiry = new factory();
//        System.out.println(factory.currencyForCountry(Country.China).symbol());
//        System.out.println(factory.currencyForCountry(Country.UK).symbol());
//        System.out.println(factory.currencyForCountry(Country.Greece).symbol());
//        System.out.println(factory.currencyForCountry(Country.US).symbol());
//
//    }
//}

//abstract class Currency {
//
//    public String symbol() {
//        return null;
//    }
//
//    public String code(){
//        return null;
//    }
//}
//
//class Euro extends Currency {
//
//    @Override
//    public String code() {
//        return "ERU";
//    }
//    @Override
//    public String symbol() {
//        return "€";
//    }
//
//}
//
//class USDolar extends Currency {
//
//    @Override
//    public String code() {
//        return "USD";
//    }
//
//    @Override
//    public String symbol() {
//        return "$";
//    }
//}
//
//class RMB extends Currency {
//
//    @Override
//    public String code() {
//        return "RMB";
//    }
//
//    @Override
//    public String symbol() {
//        return "¥";
//    }
//}
//
///*Java 中泛型只能用于 类*/
//public class factory {
//    public static <T extends Currency>T currencyForCountry(Class<T> c){
//
//        Currency human = null;
//        try {
//            human = (Currency) Class.forName(c.getName()).newInstance();
//        } catch (Exception e) {
//            System.out.println("人类生成错误");
//            e.printStackTrace();
//        }
//        return (T) human;
//
//    }
//
//    public static void main(String[] args) {
//
//        System.out.println(factory.currencyForCountry(Euro.class).symbol());
//        System.out.println(factory.currencyForCountry(USDolar.class).symbol());
//        System.out.println(factory.currencyForCountry(RMB.class).symbol());
//        System.out.println(factory.currencyForCountry(Euro.class).symbol());
//    }
//}





