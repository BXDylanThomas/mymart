package com.dylan.dto;

import lombok.Data;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 15:00
 */
@Data
public class AddressQueryResponse extends UserAbstractResponse {
    private List<AddressDto> addressDtoList;
}
