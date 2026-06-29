package br.com.alan.GerenciadorDeTarefas.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class JWTService {

    private final JwtEncoder encoder;

    public String gerarToken(Authentication auth) {
        Instant agora = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("gerenciador-tarefas")
                .issuedAt(agora)
                .expiresAt(agora.plus(1, ChronoUnit.HOURS))
                .subject(auth.getName())
                .build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }





}
