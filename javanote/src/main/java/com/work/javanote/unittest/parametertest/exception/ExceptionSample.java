package com.work.javanote.unittest.parametertest.exception;

import lombok.AllArgsConstructor;

public class ExceptionSample {
    public void checkExceptionPublic(Integer times,Integer molJcicRemainsCount) throws ValidException {
        if (times >= molJcicRemainsCount) {
            throw new ValidException(ErrorCode.JCIC_COUNT_EXCEED_THREE_TIMES);
        }
    }

    private void checkExceptionPrivate(Integer times,Integer molJcicRemainsCount) throws ValidException {
        if (times >= molJcicRemainsCount) {
            throw new ValidException(ErrorCode.JCIC_COUNT_EXCEED_THREE_TIMES);
        }
    }

    @AllArgsConstructor
    enum ErrorCode implements ErrorInfo {
        JCIC_COUNT_EXCEED_THREE_TIMES("Z21驗證次數太多");

        private final String message;

        @Override
        public String getErrorMessage() {
            return this.message;
        }

        @Override
        public String getErrorCode() {
            return this.name();
        }
    }
}
