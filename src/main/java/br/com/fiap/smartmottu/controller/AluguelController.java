package br.com.fiap.smartmottu.controller;

import br.com.fiap.smartmottu.dto.AluguelRequestDto;
import br.com.fiap.smartmottu.entity.Moto;
import br.com.fiap.smartmottu.entity.enuns.StatusEnum;
import br.com.fiap.smartmottu.repository.MotoRepository;
import br.com.fiap.smartmottu.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @Autowired
    private MotoRepository motoRepository;

    @GetMapping("/new")
    public String newFormAluguel(Model model) {
        model.addAttribute("aluguelRequest", new AluguelRequestDto());

        LocalDate localDate = LocalDate.now();

        AluguelRequestDto aluguelRequestDto = new AluguelRequestDto();

        aluguelRequestDto.setDataInicio(localDate);

        List<Moto> motosDisponiveis = motoRepository.findByStatus_Status(StatusEnum.ATIVO);

        model.addAttribute("motosDisponiveis", motosDisponiveis);
        model.addAttribute("dataMinima", localDate);

        return "form-aluguel";
    }


    @PostMapping
    public String criarAluguel(AluguelRequestDto aluguelRequest,
                               RedirectAttributes redirectAttributes) {
        try {
            aluguelService.alugarMoto(aluguelRequest);

            redirectAttributes.addFlashAttribute("mensagemSucesso", "Aluguel realizado com sucesso!");

            return "redirect:/home";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/aluguel/new";
        }
    }

    @GetMapping
    public String listAluguel(Model model) {
        var alugueis = aluguelService.getAll();
        model.addAttribute("alugueis", alugueis);
        return "list-alugueis";
    }


}
