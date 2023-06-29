package com.sqhg.services;

import lombok.AllArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sqhg.entities.Administrador;
import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Questionario;
import com.sqhg.entities.SuperiorImediato;
import com.sqhg.repositories.AdministradorRepository;
import com.sqhg.repositories.QuestionarioRepository;
import com.sqhg.repositories.SuperiorImediatoRepository;

@Service
@AllArgsConstructor
public class QuestionarioServiceImpl implements QuestionarioService {
    private final QuestionarioRepository questionarioRepository;
    private final SuperiorImediatoRepository superiorImediatoRepository;
    private final AdministradorRepository administradorRepository;

    @Override
    public List<SuperiorImediato> buscarSuperioresPorAreasECargos(List<String> areas, List<String> cargos) {
        return superiorImediatoRepository.findByAreaNomeInAndCargoIn(areas, cargos);
    }

    @Override
    public Page<Questionario> acharQuestionariosPorPagina(int pageNo, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        if (keyword == null) {
            return questionarioRepository.findAll(pageable);
        } else {
            return questionarioRepository.acharQuestionariosPorPagina(keyword, pageable);
        }
    }

    @Override
    public String salvarQuestionario(List<SuperiorImediato> superiores, ModeloQuestionario modeloquestionario,
            Date dataInicio, Date dataFim, LocalTime horaInicio, LocalTime horaFim) {
        Questionario questionario = new Questionario();
        questionario.setDescricao(modeloquestionario.getDescricao());
        questionario.setNome(modeloquestionario.getNome());
        questionario.setModeloQuestionario(modeloquestionario);
        questionario.setAdministrador(buscarAdministradorLogado());
        questionario.setCodigo(gerarCodigoAleatorio());
        questionario.setDataInicio(dataInicio);
        questionario.setDataFim(dataFim);
        questionario.setHoraInicio(horaInicio);
        questionario.setHoraFim(horaFim);
        Questionario questionarioSalvo = questionarioRepository.save(questionario);

        for (SuperiorImediato superior : superiores) {
            superior.getQuestionario().add(questionarioSalvo);
        }
        superiorImediatoRepository.saveAll(superiores);
        return questionarioSalvo.getCodigo();
    }

    public Administrador buscarAdministradorLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String crachaAdministrador = authentication.getName();
        return administradorRepository.findByCracha(crachaAdministrador);
    }

    public String gerarCodigoAleatorio() {
        String codigo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 15);
        return codigo;
    }
}
