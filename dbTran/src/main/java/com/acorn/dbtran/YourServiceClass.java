package com.acorn.dbtran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@Service
public class YourServiceClass {
   
    MemberDao2 dao2;
    
    
    PlatformTransactionManager tm;

    @Transactional(rollbackFor = Exception.class) // Add the @Transactional annotation
    public void insertA1WithTx2(Member member) throws Exception {
        try {
            System.out.println("one");
            dao2.insertUser(member);
            dao2.insertUser(member);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
