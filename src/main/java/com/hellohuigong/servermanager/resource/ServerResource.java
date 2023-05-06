package com.hellohuigong.servermanager.resource;

import com.hellohuigong.servermanager.model.Response;
import com.hellohuigong.servermanager.service.implementation.ServerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResource {
    private final ServerServiceImpl serverService;
    public ResponseEntity<Response> getServers(){
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(Map.of("servers", serverService.list(30) ))
                .message("servers retrieved")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }


}
