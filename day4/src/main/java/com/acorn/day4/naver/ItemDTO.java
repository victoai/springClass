package com.acorn.day4.naver;

import lombok.Data;

/*
 * "title": "전국에서 줄서먹는 춘천카페 감자밭 원조 감자<b>빵</b> 10개입 택배",
"link": "https://search.shopping.naver.com/gate.nhn?id=82634512334",
"image": "https://shopping-phinf.pstatic.net/main_8263451/82634512334.2.jpg",
"lprice": "29700",
 */
@Data
public class ItemDTO {

	String title;
	String link;
	String image;
	String lprice;
	 
}
