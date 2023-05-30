package util;

public class ConvIndexToMoney {
    public static String convIndexToMoney(int index){
        String money;
        switch (index) {
            case 0: money="100€"; break;
            case 1: money="200€"; break;
            case 2: money="300€"; break;
            case 3: money="500€"; break;
            case 4: money="1000€"; break;
            case 5: money="2000€"; break;
            case 6: money="4000€"; break;
            case 7: money="8000€"; break;
            case 8: money="1600€"; break;
            case 9: money="3200€"; break;
            case 10: money="6400€"; break;
            case 11: money="125000€"; break;
            case 12: money="250000€"; break;
            case 13: money="500000€"; break;
            case 14: money="1000000€"; break;
            default: money="nothing:("; break;
        }
        return money;
    }
}
