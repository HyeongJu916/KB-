package com.kb.shop.service;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @Autowired
    ShippingRepository ShippingRepository;

    public ShippingInfo getSippingInfo (Long id) {
        return ShippingRepository.selectSippingInfo(id);
    }

    public ShippingInfo setSippingInfo (ShippingInfo shippingInfo) {
        ShippingRepository.setShippingInfo(shippingInfo);
        return ShippingRepository.selectSippingInfoByOrderId(shippingInfo.getOrder_id());
    }

    public void updateShippingInfo(ShippingInfo shippingInfo) { ShippingRepository.updateShippingInfo(shippingInfo); };

}


