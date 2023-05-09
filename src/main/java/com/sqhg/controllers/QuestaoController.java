package com.sqhg.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sqhg.model.Questao;

@Controller
public class QuestaoController {
    
    List<Questao> questoes = new ArrayList<>();

    @GetMapping("/criarQuestao")
    public ModelAndView questao() {
        ModelAndView mav = new ModelAndView("criarQuestao");
        mav.addObject("questao", new Questao());
        return mav;
    }

    @PostMapping("/criarQuestao")
    public String criarQuestao(Questao questao) {
        System.out.println(" Get ID" + questao.getId());

    if (questao.getId() != null) {
      Questao questaoFind = questoes.stream().filter(questaoItem -> questao.getId().equals(questaoItem.getId())).findFirst().get();
      questoes.set(questoes.indexOf(questaoFind), questao);
    } else {
      Long id = questoes.size() + 1L;
      questoes.add(new Questao(id, questao.getDescricao(), questao.getTipo()));
    }

    return "redirect:/listarQuestao";
    }

    @GetMapping("/listarQuestao")
  public ModelAndView listarQuestao() {
    ModelAndView mav = new ModelAndView("listarQuestao");
    mav.addObject("questoes", questoes);
    return mav;
  }

  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable("id") Long id) {
    ModelAndView mav = new ModelAndView("create");

    Questao questaoFind = questoes.stream().filter(questao -> id.equals(questao.getId())).findFirst().get();
    mav.addObject("questao", questaoFind);
    return mav;
  }

}
