package com.tgi_confession.tgi_confession_db.service;

import java.util.List;

import com.tgi_confession.tgi_confession_db.dto.ReactionDto;
import com.tgi_confession.tgi_confession_db.model.Reaction;

public interface ReactionService extends BaseService<ReactionDto, List<Reaction>, String, Reaction> {
    Reaction create(String id);
}
