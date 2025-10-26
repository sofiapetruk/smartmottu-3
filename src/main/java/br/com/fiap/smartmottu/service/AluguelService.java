package br.com.fiap.smartmottu.service;

import br.com.fiap.smartmottu.dto.AluguelRequestDto;
import br.com.fiap.smartmottu.dto.AluguelResponseDto;
import br.com.fiap.smartmottu.entity.Aluguel;
import br.com.fiap.smartmottu.entity.Moto;
import br.com.fiap.smartmottu.entity.StatusMoto;
import br.com.fiap.smartmottu.entity.Usuario;
import br.com.fiap.smartmottu.entity.enuns.StatusAluguel;
import br.com.fiap.smartmottu.entity.enuns.StatusEnum;
import br.com.fiap.smartmottu.exception.NotFoundException;
import br.com.fiap.smartmottu.repository.AluguelRepository;
import br.com.fiap.smartmottu.repository.MotoRepository;
import br.com.fiap.smartmottu.repository.StatusMotoRepository;
import br.com.fiap.smartmottu.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private StatusMotoRepository statusMotoRepository;


    public AluguelResponseDto alugarMoto(AluguelRequestDto filter) {

        Usuario usuario = validarUsuario(filter.getEmail());
        Moto moto = validarMoto(filter.getMotoId(), usuario.getIdUsuario());

        LocalDate dataInicio = filter.getDataInicio();
        LocalDate dataFim = filter.getDataFim();

        Double valorTotal = calcularValorTotal(dataInicio, dataFim);

        atualizarStatusAlugada(moto);

        Aluguel aluguel = Aluguel.builder()
                .usuario(usuario)
                .moto(moto)
                .dataInicio(dataInicio)
                .dataFim(dataFim)
                .valorTotal(valorTotal)
                .statusAluguel(StatusAluguel.ATIVO)
                .build();

        aluguelRepository.save(aluguel);

        return AluguelResponseDto.from(aluguel);

    }

    private Usuario validarUsuario(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(NotFoundException.forEmail(email));

        aluguelRepository.findAluguelAtivoByUsuarioId(usuario.getIdUsuario(), StatusAluguel.ATIVO)
                .ifPresent(a -> {
                    NotFoundException.forUsuarioAluguel();
                });

        return usuario;
    }

    private Moto validarMoto(Long motoId, Long usuarioId) {
        Moto moto = motoRepository.findById(motoId)
                .orElseThrow(NotFoundException.forMoto(motoId));

        if (!moto.getStatus().getStatus().equals(StatusEnum.ATIVO)) {
            throw new RuntimeException("Moto não disponível");
        }
        return moto;
    }


    private Double calcularValorTotal(LocalDate dataInicio, LocalDate dataFim) {
        long dias = Math.abs(ChronoUnit.DAYS.between(dataInicio, dataFim));
        double valorDiario = 50;

        return dias * valorDiario;
    }

    private void atualizarStatusAlugada(Moto moto) {
        StatusMoto statusMoto = statusMotoRepository.findByStatus(StatusEnum.ALUGADA)
                .orElseThrow(NotFoundException.forAluguel());

        moto.setStatus(statusMoto);
        motoRepository.save(moto);
    }

    public String getStatusDias(Aluguel aluguel) {

        LocalDate hoje = LocalDate.now();
        LocalDate dataInicio = aluguel.getDataInicio();
        LocalDate dataFim = aluguel.getDataFim();

        if (hoje.isAfter(dataFim)) {
            return "INATIVO";
        }

        if (hoje.isEqual(dataInicio) || hoje.isAfter(dataInicio)) {
            return "ATIVO";
        }

        return "";
    }

    public List<AluguelResponseDto> getAll() {
        return aluguelRepository.findAll()
                .stream()
                .map(AluguelResponseDto::from)
                .toList();
    }

    public AluguelResponseDto getById(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(NotFoundException.forAluguel());

        return AluguelResponseDto.from(aluguel);
    }


}



