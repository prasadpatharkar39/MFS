package com.magicflare.demo.exceptionhandler.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class NoResourceFoundException extends RuntimeException {

    private String message;
}