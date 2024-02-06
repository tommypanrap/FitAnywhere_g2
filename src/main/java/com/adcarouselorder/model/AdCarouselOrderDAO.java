package com.adcarouselorder.model;

import java.util.List;

public interface AdCarouselOrderDAO {
	public void insert(AdCarouselOrderVO adCarouselOrderVO);
	public void update(AdCarouselOrderVO adCarouselOrderVO);
	public void delete(Integer adcId);
	public AdCarouselOrderVO findByPrimaryKey(Integer adcId);
	public List<AdCarouselOrderVO> getAll();
	
//	public Set<AdVO> getAdByAdc
	
}
