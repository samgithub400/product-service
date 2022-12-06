package com.ios.productservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductRequest {
	private String name;
	private String description;
	private double price;
}
