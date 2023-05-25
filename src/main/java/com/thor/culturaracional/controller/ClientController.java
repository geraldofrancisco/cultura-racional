package com.thor.culturaracional.controller;

import com.thor.culturaracional.dto.LoggedUserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @GetMapping("/logged-user")
    public Mono<LoggedUserDTO> home(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
                                    @AuthenticationPrincipal OidcUser oidcUser) {
        return Mono.just(LoggedUserDTO.builder()
                        .username(oidcUser.getClaims().get("sub").toString())
                        .permissions((List<String>)oidcUser.getClaims().get("authorities"))
                .build());
    }
}
