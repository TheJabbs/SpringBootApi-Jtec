package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Token;
import com.csis231.api.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    @Autowired
    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }

    public Token getTokenById(Long id) {
        return tokenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Token not found"));
    }

    public Token createToken(Token token) {
        return tokenRepository.save(token);
    }

    public Token updateToken(Long id, Token tokenDetails) {
        Token existingToken = tokenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found : " + id));

        existingToken = tokenDetails.clone();

        return tokenRepository.save(existingToken);
    }

    public Map<String, Boolean> deleteToken(Long token) {
        Optional<Token> optionalToken = tokenRepository.findById(token);
        if (optionalToken.isEmpty()) {
            throw new ResourceNotFoundException("Token not found : " + token);
        }

        tokenRepository.deleteById(token);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}