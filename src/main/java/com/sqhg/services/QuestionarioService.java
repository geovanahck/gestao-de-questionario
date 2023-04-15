package com.sqhg.services;

import java.time.Instant;
import java.util.List;
import com.sqhg.controllers.dto.IncluirNovoModeloQuestionarioResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sqhg.controllers.NovoModeloQuestionarioController;
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
        var data = Instant.now();

        var questionario = new Questionario();
        BeanUtils.copyProperties(questionarioRequest, questionario);
        questionario.setDataCadastro(data);
        questionario.setUltimaAtualizacao(data);
        novoModeloQuestionarioRepository.save(questionario);

        return questionario;
    }

    public ModeloQuestionario atualizar(AtualizarModeloQuestionarioRequest atualizarQuestionarioRequest) {
        var questionario = novoModeloQuestionarioRepository.findById(atualizarQuestionarioRequest.getId()).get();

        BeanUtils.copyProperties(atualizarQuestionarioRequest, questionario);
        questionario.IncluirNovoModeloQuestionarioResponse.;
        questionario.setUltimaAtualizacao(Instant.now());
        novoModeloQuestionarioRepository.save(questionario);
        return questionario;
    }

    public void deletar(Long id) {
        novoModeloQuestionarioRepository.deleteById(id);
    }
}
