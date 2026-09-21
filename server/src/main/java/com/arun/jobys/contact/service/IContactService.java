package com.arun.jobys.contact.service;

import com.arun.jobys.dto.ContactRequestDto;

public interface IContactService {
    boolean saveContact(ContactRequestDto contactRequestDto);
}
