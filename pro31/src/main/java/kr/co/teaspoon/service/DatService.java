package kr.co.teaspoon.service;

import kr.co.teaspoon.dto.Dat;

import java.util.List;

public interface DatService {
    public List<Dat> datList(int par) throws Exception;

    void datInsert(Dat dto) throws Exception;

    void datEdit(Dat dto) throws Exception;

    public void datDelete(int dno) throws Exception;

}
