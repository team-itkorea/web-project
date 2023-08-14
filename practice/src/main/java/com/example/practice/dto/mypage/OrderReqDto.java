package com.example.practice.dto.mypage;

import com.example.practice.mypage.Order;

import lombok.Data;

@Data
public class OrderReqDto {
    private int orderCode;
    private int userCode;
    private int programCode;
    private int flagCode;
    private int flagNum;
    private String programTitle;
    private String programfileName;
    
   

}
