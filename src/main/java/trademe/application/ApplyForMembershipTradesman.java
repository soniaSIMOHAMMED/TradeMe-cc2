package trademe.application;

import trademe.domain.Contractor;
import trademe.domain.Trade;
import trademe.domain.Tradesman;
import trademe.domain.User;

public final class ApplyForMembershipTradesman /*implements ApplyForMembership*/{
    /*private boolean isAllowed;
    private User user;

    public ApplyForMembershipTradesman(User user) {
        this.user = user;
        if(this.user.VerifyApplication()){isAllowed=true;}

    }

    @Override
    public void apply() {
        System.out.println("Application for Membership ! please wait we are verifying your information ...");
        if(isAllowed){
            System.out.println("Great! you're application has been successfully verified !");
            Tradesman newTradesman = new Tradesman(user.getUserId(),user.getTradeString(user.getTrade()));
        }else{
            System.out.println("Sorry! something went wrong with your application ! " );
        }
    }*/
}
