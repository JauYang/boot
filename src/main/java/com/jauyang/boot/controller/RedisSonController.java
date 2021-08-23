package com.jauyang.boot.controller;

import com.jauyang.boot.common.api.CommonResult;
import com.jauyang.boot.dto.MessageDto;
import com.jauyang.boot.queue.RedisTopicQueue;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.RKeys;
import org.redisson.api.RMap;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;

/**
 * @author Yann
 * @date 2021-08-06 18:19
 */
@RestController
@RequestMapping("/redisSon")
public class RedisSonController {

    private final RedissonClient redissonClient;

    private final RedisTopicQueue redisTopicQueue;

    public RedisSonController(RedissonClient redissonClient, RedisTopicQueue redisTopicQueue) {
        this.redissonClient = redissonClient;
        this.redisTopicQueue = redisTopicQueue;
    }

    @ApiOperation("get redis")
    @GetMapping(value = "/get")
    public CommonResult<Object> getKey(@QueryParam("key") String key) {
        RMap<String, Object> testMap = redissonClient.getMap("TEST_KEY");
        return CommonResult.success(testMap.get(key));
    }

    @ApiOperation("put redis")
    @PutMapping(value = "/put")
    public CommonResult<Object> putKey(@QueryParam("key") String key, @QueryParam("value") String value) {
        RMap<String, Object> testMap = redissonClient.getMap("TEST_KEY");
        testMap.put(key, value);
        return CommonResult.success();
    }

    @ApiOperation("put redis topic")
    @PostMapping(value = "/put-topic")
    public CommonResult<Object> putTopic(@RequestBody MessageDto messageDto) {
        redisTopicQueue.publish(messageDto);
        return CommonResult.success();
    }
}
