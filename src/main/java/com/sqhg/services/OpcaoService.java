package com.sqhg.services;

import java.util.List;

import com.sqhg.entities.Opcao;

public interface OpcaoService {

  List<Opcao> findOpcoesByQuestaoId(Long questaoID);

}
