package com.aquakloud.PosSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerSaveRequestDTO {

    private String customerName;
    private String customerAddress;
    private ArrayList contactNumber;
    private String nic;
    private boolean activeState;

}
