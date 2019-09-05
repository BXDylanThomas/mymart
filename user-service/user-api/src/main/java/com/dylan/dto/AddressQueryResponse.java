package com.dylan.dto;

import com.dylan.Result.AbstractResponse;
import lombok.Data;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 15:00
 */
@Data
public class AddressQueryResponse extends AbstractResponse {
    private List<AddressDto> addressDtoList;
}
