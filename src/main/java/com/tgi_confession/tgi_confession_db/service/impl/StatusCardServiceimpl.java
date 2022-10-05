package com.tgi_confession.tgi_confession_db.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tgi_confession.tgi_confession_db.dto.StatusCardDto;
import com.tgi_confession.tgi_confession_db.model.StatusCard;
import com.tgi_confession.tgi_confession_db.repository.ReactionRepository;
import com.tgi_confession.tgi_confession_db.repository.StatusCardRepository;
import com.tgi_confession.tgi_confession_db.service.ReactionService;
import com.tgi_confession.tgi_confession_db.service.StatusCardService;

@Service
public class StatusCardServiceimpl extends BaseServiceimpl<StatusCardDto, List<StatusCard>, String, StatusCard>
        implements StatusCardService {

    @Autowired
    private StatusCardRepository statusCardRepository;

    @Autowired
    private ReactionRepository reactionRepository;

    @Autowired
    private ReactionService reactionService;

    @Override
    protected JpaRepository<StatusCard, String> getModelRepository() {
        return statusCardRepository;
    }

    @Override
    protected StatusCard getCreateRespond(StatusCardDto modelDto) {
        StatusCard statusCard = new StatusCard(UUID.randomUUID().toString(), new Date(), modelDto.getDescription(),
                "Active");
        reactionService.create(statusCard.getId());
        return statusCard;
    }

    @Override
    protected StatusCard getUpdateRespond(String id, StatusCardDto modelDto) {
        Optional<StatusCard> optionalStatusCard = statusCardRepository.findById(id);
        StatusCard statusCard = optionalStatusCard.get();
        statusCard.setDescription(modelDto.getDescription());
        return statusCard;
    }

    @Override
    public StatusCard delete(String id) {
        Optional<StatusCard> optionalStatusCard = statusCardRepository.findById(id);
        statusCardRepository.deleteById(id);
        reactionRepository.deleteById(id);
        return optionalStatusCard.get();
    }
}
