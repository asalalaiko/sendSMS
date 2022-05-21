package by.asalalaiko.sendsms.twilio.controller;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    @Value("${twilio.account.sid}")
    private  String username;
    @Value("${twilio.auth.token}")
    private  String password;
    @Value("${twilio.phonenumber.from}")
    private  String phonenumberFrom;

    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS(@RequestParam(required = true) String phone, @RequestParam(required = true) String code) {

        Twilio.init(username, password);

        Message.creator(new PhoneNumber("+"+phone), new PhoneNumber(phonenumberFrom), "Your code: " + code).create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
}
