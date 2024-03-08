package com.joaoalencar.fintechsimulator.service;

import java.math.BigDecimal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaoalencar.fintechsimulator.domain.transfer.Transfer;
import com.joaoalencar.fintechsimulator.domain.user.UserType;
import com.joaoalencar.fintechsimulator.repository.TransferRespository;
import com.joaoalencar.fintechsimulator.repository.UserRepository;
import com.joaoalencar.fintechsimulator.service.dto.TransferDTO;
import com.joaoalencar.fintechsimulator.service.exception.BadTransferException;
import com.joaoalencar.fintechsimulator.service.exception.UserNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class TransferService {

    @Autowired
    private TransferRespository transferRespository;

    @Autowired
    private UserRepository userRepository;

    private void validateTransfer(TransferDTO transferDTO) {
        var payer = userRepository.findById(transferDTO.getPayerId())
                .orElseThrow(() -> new UserNotFoundException("Pagador nao existe"));

        if (payer.getType().equals(UserType.SHOPKEEPER)) {
            throw new BadTransferException("Lojistas nao podem fazer transferencias para outros usuarios.");
        }

        if (payer.getBalance().compareTo(transferDTO.getAmount()) < 0) {
            throw new BadTransferException("Saldo em conta insuficiente para a operacao");
        }

        userRepository.findById(transferDTO.getPayeeId())
                .orElseThrow(() -> new UserNotFoundException("Recebedor nao encontrado"));
    }

    public List<TransferDTO> findUserTransfers(Integer userId) {
        return transferRespository.findByPayerIdOrPayeeId(userId, userId)
                .stream()
                .map(t -> {
                    if (t.getPayerId().equals(userId)) {
                        var amount = t.getAmount().multiply(new BigDecimal(-1));
                        t.setAmount(amount);
                    }

                    return new ModelMapper().map(t, TransferDTO.class);
                })
                .toList();
    }

    @Transactional
    public void createTransfer(TransferDTO transferDTO) {
        validateTransfer(transferDTO);

        var transfer = new ModelMapper().map(transferDTO, Transfer.class);
        transferRespository.save(transfer);

        userRepository.updateBalance(transferDTO.getPayerId(), transferDTO.getAmount().multiply(new BigDecimal(-1)));
        userRepository.updateBalance(transferDTO.getPayeeId(), transferDTO.getAmount());
    }
}
