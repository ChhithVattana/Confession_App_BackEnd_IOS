package com.tgi_confession.tgi_confession_db.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tgi_confession.tgi_confession_db.dto.ReactionDto;
import com.tgi_confession.tgi_confession_db.model.Reaction;
import com.tgi_confession.tgi_confession_db.repository.ReactionRepository;
import com.tgi_confession.tgi_confession_db.service.ReactionService;

@Service
public class Reactionimpl extends BaseServiceimpl<ReactionDto, List<Reaction>, String, Reaction>
        implements ReactionService {

    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public Reaction create(String id) {
        Reaction reaction = new Reaction(id, 0, 0, 0, 0, 0, 0);
        return reactionRepository.save(reaction);
    }

    @Override
    protected JpaRepository<Reaction, String> getModelRepository() {
        return reactionRepository;
    }

    @Override
    protected Reaction getCreateRespond(ReactionDto modelDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Reaction getUpdateRespond(String id, ReactionDto modelDto) {
        Optional<Reaction> optionalReaction = reactionRepository.findById(id);
        Reaction reaction = optionalReaction.get();
        if (modelDto.getLikes() == 1) {
            reaction.setLikes(reaction.getLikes() + 1);
        } else if (modelDto.getLove() == 1) {
            reaction.setLove(reaction.getLove() + 1);
        } else if (modelDto.getHaha() == 1) {
            reaction.setHaha(reaction.getHaha() + 1);
        } else if (modelDto.getSad() == 1) {
            reaction.setWow(reaction.getWow() + 1);
        } else if (modelDto.getAngry() == 1) {
            reaction.setSad(reaction.getSad() + 1);
        } else if (modelDto.getAngry() == 1) {
            reaction.setAngry(reaction.getAngry() + 1);
        } else if (modelDto.getLikes() == -1) {
            reaction.setLikes(reaction.getLikes() - 1);
        } else if (modelDto.getLove() == -1) {
            reaction.setLove(reaction.getLove() - 1);
        } else if (modelDto.getHaha() == -1) {
            reaction.setHaha(reaction.getHaha() - 1);
        } else if (modelDto.getSad() == -1) {
            reaction.setWow(reaction.getWow() - 1);
        } else if (modelDto.getAngry() == -1) {
            reaction.setSad(reaction.getSad() - 1);
        } else if (modelDto.getAngry() == -1) {
            reaction.setAngry(reaction.getAngry() - 1);
        }
        return reaction;
    }

}
