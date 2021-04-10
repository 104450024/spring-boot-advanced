package com.irm.springbootadvance.form;


public interface FormConvert<S,T>
{
    T convert(S s);
}
