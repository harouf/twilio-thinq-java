import com.twilio.thinq.TwilioWrapperLibrary;
import com.twilio.thinq.TwilioWrapperLibraryBuilder;


public class Main {
    public static void main(String[] agrgs){
        TwilioWrapperLibrary library = new TwilioWrapperLibraryBuilder()
                // customer phone number to call
                .customer("+86 131 3051 1523")
                // twilio account sid, account token, registered twilio phone number
                .twilio("ACa5a21802beff96f147d40bf98c957038", "7852c807435af28d468344ca57a49d2a", "+1 754-333-6811")
                // wrap and build the library
                .buildLibrary();
        String result = library.call(); //return value is call sid if success, otherwise error message.
        System.out.println("result: " + result);
    }
}
