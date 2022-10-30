package com.kuc.dtos;

import com.kuc.entities.BuildType;

public class OrderDto {
    public static class CreateOrderDto {
        public int area;
        public BuildType buildType;
        public String fullName;
    }
}