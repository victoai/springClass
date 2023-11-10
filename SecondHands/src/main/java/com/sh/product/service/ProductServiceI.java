package com.sh.product.service;

import java.util.List;
import java.util.Map;

import com.sh.product.domain.ProductDTO;
import com.sh.product.domain.cateDTO;

public interface ProductServiceI {
   
   //상품 전체 목록
   List<ProductDTO> getProductList();

   //조회수
    void increaseClick(String boardId);

    //상품 등록
    void insertProductData(ProductDTO product);

    //상품 한개 조회 = 디테일
    ProductDTO getProductById(String boardId);

    //상품 등록 , 삭제시 사용할 카테고리
    String  getAllCategoriesJson();
    List<cateDTO> getCategory();
    List<cateDTO> getAllCategories(String loc_code);

    //상품 삭제
    void deleteProduct(String boardId);

    //상품 수정
    int updateProduct(ProductDTO product);

 
    // 좋아요 개수 조회
    int getLikeCount(String boardId);
    
    void toggleLike(String boardId, String userCode);
///////////////////////
   void insertLike(ProductDTO product);
    void updateDate(String boardId);
}