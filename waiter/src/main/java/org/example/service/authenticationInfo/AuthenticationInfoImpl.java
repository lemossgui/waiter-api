package org.example.service.authenticationInfo;

import org.example.security.PayloadToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class AuthenticationInfoImpl implements AuthenticationInfo {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private PayloadToken getPayloadToken() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return (PayloadToken) auth.getPrincipal();
        } catch (Exception e) {
            logger.info("Falha na autenticação, acesso negado");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long getUserId() {
        return Objects.requireNonNull(getPayloadToken()).getUserId();
    }
}
