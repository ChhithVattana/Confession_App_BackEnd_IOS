package com.tgi_confession.tgi_confession_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tgi_confession.tgi_confession_db.dto.StatusCardDto;
import com.tgi_confession.tgi_confession_db.model.StatusCard;
import com.tgi_confession.tgi_confession_db.service.StatusCardService;

@RestController
@RequestMapping("/statuscard")
public class StatusCardController {

    @Autowired
    private StatusCardService statusCardService;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<List<StatusCard>> getAllStatusCard() {
        return new ResponseEntity<>(statusCardService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = { "getById" }, method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<StatusCard> getById(String id) {
        if (statusCardService.getById(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(statusCardService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<StatusCard> createStatus(@RequestBody StatusCardDto statusCardDto) {
        return new ResponseEntity<>(statusCardService.create(statusCardDto), HttpStatus.OK);
    }

    @RequestMapping(value = { "delete" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<StatusCard> deleteStatus(@RequestParam String id) {
        return new ResponseEntity<>(statusCardService.delete(id), HttpStatus.OK);
    }

    @RequestMapping(value = { "update" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<StatusCard> updateStatus(@RequestParam String id, @RequestBody StatusCardDto statusCardDto) {
        return new ResponseEntity<>(statusCardService.update(id, statusCardDto), HttpStatus.OK);
    }
}
