package com.hamitmizrak.tokenmail;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// LOMBOK
@Data
@RequiredArgsConstructor // Injection

@Transactional
@Service
public class ForRegisterTokenEmailConfirmationServicesImpl implements IForRegisterTokenEmailConfirmationServices<ForRegisterTokenEmailConfirmationEntity> {

    // INJECTION
    private final IForRegisterTokenEmailConfirmationEntity iTokenRepository;

    // CREATE TOKEN
    // Mailine gelen linke tıkladığımda çalışacak metot
    @Override
    public String createToken(ForRegisterTokenEmailConfirmationEntity tokenConfirmationEntity) {
        ForRegisterTokenEmailConfirmationEntity tokenConfirmationEntity1=iTokenRepository.save(tokenConfirmationEntity);
        return tokenConfirmationEntity1.getToken();
    }

    // DELETE TOKEN
    // Mailine gelen linke tıkladığımda token silinecek metot
    @Override
    public void deleteToken(Long id) {
         iTokenRepository.deleteById(id);
    }
} //end class
