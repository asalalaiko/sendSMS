package by.asalalaiko.sendsms.twilio.controller;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {
    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS() {

        Twilio.init("AC5a3e5e089e068915532b3fb3a88ef550", "011bde7006a5ab4126a2ecca5c32b620");

        Message.creator(new PhoneNumber("+375297832572"),
                new PhoneNumber("+19207813784"), "Hello from Twilio 📞").create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
}
