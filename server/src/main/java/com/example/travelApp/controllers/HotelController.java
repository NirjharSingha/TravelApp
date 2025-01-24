package com.example.travelApp.controllers;

import com.example.travelApp.dto.*;
import com.example.travelApp.services.impl.HotelServiceImpl;
import com.example.travelApp.services.impl.PaymentServiceImpl;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotel")
@CrossOrigin
public class HotelController {
    @Autowired
    private HotelServiceImpl hotelService;

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping("/regHotel")
    public ResponseEntity<String> regHotel(@RequestParam(value = "documents", required = false) MultipartFile[] files,
                                                   @RequestParam (value = "file", required = false) MultipartFile file,
                                                   @ModelAttribute RegHotelDto regHotelDto) {
        try {
            List<MultipartFile> documents = new ArrayList<>();
            if (files != null) {
                for (MultipartFile f : files) {
                    if (!f.isEmpty()) {
                        documents.add(f);
                    }
                }
            }
            if (file != null && !file.isEmpty()) {
                regHotelDto.setImage(file.getBytes());
            }
            return hotelService.regHotel(documents, regHotelDto);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/editHotel")
    public ResponseEntity<String> editHotel(@RequestParam (value = "file", required = false) MultipartFile file,
                                           @ModelAttribute HotelDto hotelDto) {
        try {
            if (file != null && !file.isEmpty()) {
                hotelDto.setImage(file.getBytes());
            }
            return hotelService.editHotel(hotelDto);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/addRoom")
    public ResponseEntity<String> addRoom(@RequestParam(value = "attachments", required = false) MultipartFile[] files,
                                          @ModelAttribute RoomDto roomDto) {
        try {
            List<MultipartFile> documents = new ArrayList<>();
            if (files != null) {
                for (MultipartFile f : files) {
                    if (!f.isEmpty()) {
                        documents.add(f);
                    }
                }
            }
            return hotelService.addRoom(documents, roomDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/editRoom")
    public ResponseEntity<String> editRoom(@RequestParam(value = "attachments", required = false) MultipartFile[] files,
                                          @ModelAttribute RoomDto roomDto) {
        try {
            List<MultipartFile> documents = new ArrayList<>();
            if (files != null) {
                for (MultipartFile f : files) {
                    if (!f.isEmpty()) {
                        documents.add(f);
                    }
                }
            }
            return hotelService.editRoom(documents, roomDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/getRoomsByHotelId")
    public ResponseEntity<List<GetRoomDto>> getRoomsByHotelId(@RequestParam int hotelId) {
        return hotelService.getRoomsByHotelId(hotelId);
    }

    @GetMapping("/getHotels")
    public ResponseEntity<List<HotelDto>> getHotels() {
        return hotelService.getHotels();
    }

    @GetMapping("/getHotelsByUserId")
    public ResponseEntity<List<HotelDto>> getHotelsByUserId(@RequestParam String userId) {
        return hotelService.getHotelsByUserId(userId);
    }

    @PostMapping("/payment")
    ResponseEntity<String> payment(@RequestBody Payment payment) throws StripeException {
        return ResponseEntity.ok(paymentService.createPaymentLink(payment.getAmount()));
    }
}
