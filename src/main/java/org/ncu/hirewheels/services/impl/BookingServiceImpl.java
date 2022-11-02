package org.ncu.hirewheels.services.impl;

import javax.transaction.Transactional;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.repository.BookingRepository;
import org.ncu.hirewheels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    @Transactional
    public Booking addBooking(Booking booking) {
        try {
            return bookingRepository.save(booking);
        } catch (Exception e) {
            throw e;
        }
    }

}
