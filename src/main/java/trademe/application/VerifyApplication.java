package trademe.application;

import trademe.domain.Address;
import trademe.domain.Trade;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VerifyApplication {

    private static Pattern pattern;
    private static Matcher matcher;


    public static boolean checkAge(int age) {
        return 19<age && age<63;
    }

    public static boolean checkEmail(String email) {
        final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_REGEX);


        matcher = pattern.matcher(email);
        return matcher.matches();

    }

    public static boolean checkPhone(String phoneNumber) {

        final String PHONE_REGEX = "^\\d{10}$";
        pattern = Pattern.compile(PHONE_REGEX);


        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();

    }

    // à definir plus tard
    public static Boolean checkAddress(Address address){
        return true;
    }

    public static Boolean checkTrade(Trade trade){
        return trade.equals(Trade.CARPENTER) || trade.equals(Trade.PLUMBER) || trade.equals(Trade.MASON )|| trade.equals(Trade.ELECTRICIAN);
    }



}


