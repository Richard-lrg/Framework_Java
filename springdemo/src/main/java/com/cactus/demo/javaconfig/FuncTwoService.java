package com.cactus.demo.javaconfig;

/**
 * Created by liruigao
 * Date: 2019-10-11 11:34
 * Description:普通方法类， 不声明为bean， 不依赖注入
 */


public class FuncTwoService {
    private FuncOneService funcOneService;

    public void setFuncOneService(FuncOneService funcOneService) {
        this.funcOneService = funcOneService;
    }

    public String show(String word) {
        return funcOneService.show(word);
    }
}
