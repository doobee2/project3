package kr.co.teaspoon.dao;

import kr.co.teaspoon.dto.Free;

import java.util.List;

public interface FreeDAO {
    public List<Free> freeList() throws Exception;
    public Free freeDetail(int fno) throws Exception;
    public void freeInsert(Free dto) throws Exception;
    public void freeEdit(Free dto) throws Exception;
    public void freeDelete(int fno) throws Exception;
}
