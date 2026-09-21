package com.arun.jobys.contact.service.impl;

import com.arun.jobys.contact.service.IContactService;
import com.arun.jobys.dto.ContactRequestDto;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements IContactService {
    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
        return false;
    }
}
