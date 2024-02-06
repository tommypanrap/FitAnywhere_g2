package com.fitanywhere.sub.model;

import java.util.*;

public interface SubDAO_interface {
          public void insert(SubVO subVO);
          public void update(SubVO subVO);
          public void delete(Integer su_id);
          public SubVO findByPrimaryKey(Integer uId);
          public List<SubVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}


