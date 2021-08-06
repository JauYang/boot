package com.jauyang.boot.controller;

import com.jauyang.boot.common.api.CommonResult;
import com.jauyang.boot.component.PulsarProducer;
import com.jauyang.boot.dto.MessageDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yann
 * @date 2021-08-06 18:19
 */
@Controller
@RequestMapping("/pulsar")
public class PulsarController {

    private final PulsarProducer pulsarProducer;

    public PulsarController(PulsarProducer pulsarProducer) {
        this.pulsarProducer = pulsarProducer;
    }

    @ApiOperation("发送消息")
    @PostMapping(value = "/sendMessage")
    @ResponseBody
    public CommonResult<MessageDto> sendMessage(@RequestBody MessageDto message) {
        pulsarProducer.send(message);
        return CommonResult.success(message);
    }

}
