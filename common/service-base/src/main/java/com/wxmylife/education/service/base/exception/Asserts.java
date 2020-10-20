package com.wxmylife.education.service.base.exception;

import com.wxmylife.education.utils.IErrorCode;

public class Asserts {
  public static void fail(String message) {
    throw new ApiException(message);
  }
  public static void fail(IErrorCode errorCode) {
    throw new ApiException(errorCode);
  }
}
