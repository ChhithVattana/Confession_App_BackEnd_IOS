package com.tgi_confession.tgi_confession_db.controller;

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

import com.tgi_confession.tgi_confession_db.dto.ReactionDto;
import com.tgi_confession.tgi_confession_db.model.Reaction;
import com.tgi_confession.tgi_confession_db.service.ReactionService;

@RestController
@RequestMapping("/reaction")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<Reaction> updateReaction(@RequestParam String id, @RequestBody ReactionDto reactionDto) {
        return new ResponseEntity<>(reactionService.update(id, reactionDto), HttpStatus.OK);
    }

}
