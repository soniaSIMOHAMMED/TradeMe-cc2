package trademe.application;

import trademe.domain.Contractor;
import trademe.domain.User;

public final class ApplyForMembershipContractor implements ApplyForMembership{
    private boolean isAllowed;
    private User user;

    public ApplyForMembershipContractor(User user) {
        this.user = user;
        if(this.user.VerifyApplication()){isAllowed=true;}
    }

    @Override
    public void apply() {
        System.out.println("Application for Membership ! please wait we are verifying your information ...");
        if(isAllowed){
            System.out.println("Great! you're application has been successfully verified !");
            Contractor newContractor = new Contractor(user.getUserId());
        }else{
            System.out.println("Sorry! something went wrong with your application ! " );
        }
    }
}
