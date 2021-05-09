package com.cms.backend.service;

import com.cms.backend.data.InquiryRepository;
import com.cms.backend.models.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InquiryService {
    @Autowired
    private InquiryRepository inquiryRepository;

    // Return all inquirys
    public List<Inquiry> all() {
        return (List)inquiryRepository.findAll();
    }

    public boolean create(Inquiry inquiry) {
        inquiryRepository.save(inquiry);
        return  true;
    }

    public Optional<Inquiry> read(String id) {
        return inquiryRepository.findById(id);
    }

    public boolean update(Inquiry inquiry) {
        inquiryRepository.save(inquiry);
        return true;
    }

    public boolean delete(String id) {
        Optional<Inquiry> inquiry =  inquiryRepository.findById(id);

        if(inquiry.isPresent()) {
            inquiryRepository.deleteById(id);
            return true;
        }
        return  false;
    }
}
