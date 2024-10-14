package com.web.Controller;

import com.web.Entity.Slots;
import com.web.Response.ResponseHandler;
import com.web.Service.SlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slot")
public class SlotsController
{
    @Autowired
    private SlotsService slotsService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveSlot(@RequestBody Slots slots)
    {
        return ResponseHandler.responseBuilder("Data Saved Successfully", HttpStatus.OK,slotsService.saveSlot(slots));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object>getAllSlot()
    {
        return ResponseHandler.responseBuilder("Data Fetched Successfully",HttpStatus.OK,slotsService.getAllSlots());
    }
}
