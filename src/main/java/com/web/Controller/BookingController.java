package com.web.Controller;

import com.web.Entity.Booking;
import com.web.Response.ResponseHandler;
import com.web.Service.BookingService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController
{
    @Autowired
    BookingService bookingService;

    @PostMapping("/save")
    public ResponseEntity<Object> savebooking(@RequestBody Booking booking) throws MessagingException {
        return ResponseHandler.responseBuilder("Data Saved Successfully", HttpStatus.OK,bookingService.saveUser(booking));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllData()
    {
        return ResponseHandler.responseBuilder("Data Fetched Successfully",HttpStatus.OK,bookingService.getAllData());
    }
}
