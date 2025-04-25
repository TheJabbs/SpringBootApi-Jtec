package com.csis231.api.controller;

import com.csis231.api.model.Token;
import com.csis231.api.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/tokens")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping
    public List<Token> getAllTokens() {
        return tokenService.getAllTokens();
    }

    @PostMapping
    public ResponseEntity<Token> createToken(@Valid @RequestBody Token token) {
        Token savedToken = tokenService.createToken(token);
        return new ResponseEntity<Token>(savedToken, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Token> getTokenById(@PathVariable Long id) {
        return ResponseEntity.ok(tokenService.getTokenById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateToken(@PathVariable Long id, @Valid @RequestBody Token tokenDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid token data");
        }
        Token updatedToken = tokenService.updateToken(id, tokenDetails);
        return ResponseEntity.ok(updatedToken);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToken(@PathVariable Long id) {
        tokenService.deleteToken(id);
        return ResponseEntity.noContent().build();
    }
}