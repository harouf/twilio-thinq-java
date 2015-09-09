package com.twilio.thinq;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Call;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TwilioWrapperLibrary {
    private static final String TWIML_RESOURCE_URL = "http://cris.viralearnings.com/twiml/get_response";

    private TwilioRestClient client;
    private String customer_number;
    private String twilio_account_sid;
    private String twilio_account_token;
    private String twilio_phone_number;


    public TwilioWrapperLibrary(){

    }

    /**
     * Initialize Twilio Wrapper Object
     * @param customer_number             customer phone number to call
     * @param twilio_account_sid    twilio account sid
     * @param twilio_account_token  twilio account token
     * @param twilio_phone_number   twilio phone number to be used to call customer phone number
     */

    public TwilioWrapperLibrary(String customer_number, String twilio_account_sid, String twilio_account_token, String twilio_phone_number) {
        this.customer_number = customer_number;
        this.twilio_account_sid = twilio_account_sid;
        this.twilio_account_token = twilio_account_token;
        this.twilio_phone_number = twilio_phone_number;

        this.client = new TwilioRestClient(this.twilio_account_sid, this.twilio_account_token);
    }

    /**
     * Check if the twilio client is initialized properly.
     */
    public boolean isClientValid(){
        return this.client != null && this.client.getAccount() != null;
    }

    /**
     * Initiate a call to the customer
     * @return Call sid or error string
     */
    public String call(){
        if(!this.isClientValid()) {
            return "Invalid Twilio Account details.";
        }

        // Build a filter for the CallList
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Url", this.TWIML_RESOURCE_URL));
        params.add(new BasicNameValuePair("To", this.customer_number));
        params.add(new BasicNameValuePair("From", this.twilio_phone_number));


        CallFactory callFactory = client.getAccount().getCallFactory();
        Call call;
        try {
            call = callFactory.create(params);
            return call.getSid();
        } catch (TwilioRestException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
