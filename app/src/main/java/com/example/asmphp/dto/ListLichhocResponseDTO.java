package com.example.asmphp.dto;

import java.util.List;

public class ListLichhocResponseDTO {
    private boolean status;
    private String message;
    private List<LichhocResponseDTO> data;

    public ListLichhocResponseDTO() {
    }

    public ListLichhocResponseDTO(boolean status, String message, List<LichhocResponseDTO> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LichhocResponseDTO> getData() {
        return data;
    }

    public void setData(List<LichhocResponseDTO> data) {
        this.data = data;
    }
}
