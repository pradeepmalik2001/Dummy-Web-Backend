package com.web.Service;

import com.web.Entity.Slots;
import com.web.Repository.SlotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotsService
{
    @Autowired
    private SlotsRepository slotsRepository;

    public Slots saveSlot(Slots slots)
    {
        return slotsRepository.save(slots);
    }

    public List<Slots> getAllSlots()
    {
        return slotsRepository.findAll();
    }

}
