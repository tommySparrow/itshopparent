package com.it.serviceImpl;

import com.it.entity.MbUser;
import com.it.mapper.MbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/20
 * @ Description：
 * @ throws
 */
@Service
public class UserService {

    @Autowired
    private MbUserMapper mbUserMapper;

    public Integer save(MbUser mbUser){
       return mbUserMapper.insert(mbUser);
    }
}
