package com.niko.dao;

import java.util.List;
import com.niko.pojo.ApplyInfo;

public interface ApplyInfoDao {
    void addApplyInfo(ApplyInfo applyInfo) throws Exception;
    List<ApplyInfo> getApplyInfoByGame(String game) throws Exception;
    List<ApplyInfo> getApplyInfoByClass(String className) throws Exception;
    void deleteApplyInfoByName(String name) throws Exception;
}
