package com.twilio.thinq;

public class TwilioWrapperLibraryBuilder {
    private String customer_number;
    private String twilio_account_sid;
    private String twilio_account_token;
    private String twilio_phone_number;


    public TwilioWrapperLibraryBuilder() { }

    /**
     * Wrap the library and return the library object.
     * @return
     */

    public TwilioWrapperLibrary buildLibrary()
    {
        return new TwilioWrapperLibrary(customer_number, twilio_account_sid, twilio_account_token, twilio_phone_number);
    }

    /**
     * Set customer phone number
     * @param _number   customer phone number to call
     * @return
     */

    public TwilioWrapperLibraryBuilder customer(String _number)
    {
        this.customer_number = _number;
        return this;
    }

    /**
     * Set twilio acount details
     * @param _sid  twilio account sid
     * @param _token    twilio account token
     * @param _number   registered twilio phone number
     * @return
     */

    public TwilioWrapperLibraryBuilder twilio(String _sid, String _token, String _number)
    {
        this.twilio_account_sid = _sid;
        this.twilio_account_token = _token;
        this.twilio_phone_number = _number;
        return this;
    }
}
