package com.dylan.martprovider.converter;

import com.dylan.Result.AbstractRequest;
import com.dylan.dto.GoodsDto;
import com.dylan.martprovider.dal.entity.Goods;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoodsConverter {

	@Mappings({})
	GoodsDto goodsDto(Goods goods);

	List<GoodsDto> goodsDto(List<Goods> goodsList);

}
