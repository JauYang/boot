package com.jauyang.boot.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yann
 * @date 2021-08-06 17:45
 */
@Data
public class MessageDto implements Serializable {

    private static final long serialVersionUID = 8729655111273492680L;

    private Long id;

    private String content;

}
