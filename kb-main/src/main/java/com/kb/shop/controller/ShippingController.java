package com.kb.shop.controller;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService ShippingService;

    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    @PostMapping("/")
    public ResponseEntity<ShippingInfo> setSippingInfo(@RequestBody ShippingInfo shippingInfo) {
        ShippingInfo newShippingInfo = new ShippingInfo();
        newShippingInfo = ShippingService.setSippingInfo(shippingInfo);
        if (newShippingInfo != null) {
            return new ResponseEntity<>(newShippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    @PutMapping("/")
    public void updateShippinginfo(@PathVariable ShippingInfo shippingInfo) { ShippingService.updateShippingInfo(shippingInfo); };

    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)
    @GetMapping("/{id}")
    public ResponseEntity<ShippingInfo> getSellerInfo(@PathVariable Long id) {
        ShippingInfo ShippingInfo = new ShippingInfo();
        ShippingInfo = ShippingService.getSippingInfo(id);

        if (ShippingInfo != null) {
            return new ResponseEntity<>(ShippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
