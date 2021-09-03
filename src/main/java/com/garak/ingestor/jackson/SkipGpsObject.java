package com.garak.ingestor.jackson;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface SkipGpsObject {
    String value();
}