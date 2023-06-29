package com.sqhg.config.web.converters;

import com.sqhg.entities.Questao;
import com.sqhg.repositories.QuestaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QuestaoByIdConverter implements Converter<Long, Questao> {

    private final QuestaoRepository questaoRepository;

    @Override
    public Questao convert(Long id) {
        return questaoRepository.findById(id).orElse(null);
    }
}
