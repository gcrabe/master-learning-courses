package ru.batyrev.musicstorageimpl.data.model;

import lombok.Data;

@Data
public class SystemResponse {

    private String text;

    public SystemResponse(String text) {
        this.text = text;
    }
}
