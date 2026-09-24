package com.arun.jobys.contact.service.impl;

import com.arun.jobys.contact.service.IContactService;
import com.arun.jobys.dto.ContactRequestDto;
import com.arun.jobys.entity.Contact;
import com.arun.jobys.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {
    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
        Contact contact = contactRepository.save(transformToEntity(contactRequestDto));
        return contact.getId() != null;
    }

    //mapper fn to transform the incoming data into entity type...
    private Contact transformToEntity(ContactRequestDto contactRequestDto){
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDto, contact); //copying source bean fields to destination bean
        //contact.setCreatedAt(Instant.now());
        //contact.setCreatedBy("Admin"); //can change later when authentication is added
        contact.setStatus("NEW");
        return contact;

    }
}
