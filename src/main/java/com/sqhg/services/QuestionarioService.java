package com.sqhg.services;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sqhg.controllers.dto.AtualizarModeloQuestionarioRequest;
import com.sqhg.controllers.dto.IncluirNovoModeloQuestionarioRequest;
import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Questionario;
import com.sqhg.exception.QuestionarioNaoEncontradoException;
import com.sqhg.repositories.NovoModeloQuestionarioRepository;

@Service
public class QuestionarioService {

    private final NovoModeloQuestionarioRepository novoModeloQuestionarioRepository;

    public QuestionarioService(NovoModeloQuestionarioRepository novoModeloQuestionarioRepository) {
        this.novoModeloQuestionarioRepository = novoModeloQuestionarioRepository;
    }

    public List<ModeloQuestionario> listar() {
        return novoModeloQuestionarioRepository.findAll();
    }

    public ModeloQuestionario getQuestionario(Long id) {
        return novoModeloQuestionarioRepository.findById(id)
                .orElseThrow(() -> new QuestionarioNaoEncontradoException("Questionário não encontrado " + id));
    }

    public Questionario incluir(IncluirNovoModeloQuestionarioRequest questionarioRequest) {

        var questionario = new Questionario();
        BeanUtils.copyProperties(questionarioRequest, questionario);
        novoModeloQuestionarioRepository.save(questionario);

        return questionario;
    }

    public ModeloQuestionario atualizar(AtualizarModeloQuestionarioRequest atualizarQuestionarioRequest) {
        var questionario = novoModeloQuestionarioRepository.findById(atualizarQuestionarioRequest.getId()).get();

        BeanUtils.copyProperties(atualizarQuestionarioRequest, questionario);
        novoModeloQuestionarioRepository.save(questionario);
        return questionario;
    }

    public void deletar(Long id) {
        novoModeloQuestionarioRepository.deleteById(id);
    }
}
