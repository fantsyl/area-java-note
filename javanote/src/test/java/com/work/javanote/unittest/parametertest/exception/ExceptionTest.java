package com.work.javanote.unittest.parametertest.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.UndeclaredThrowableException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class ExceptionTest {

  @InjectMocks private ExceptionSample exceptionSample;

  @Test
  void checkExceptionPublic() {
    // Arrange
    Integer times = 2;
    Integer molJcicRemainsCount = 1;
    // Act
    ValidException exception =
        assertThrows(
            ValidException.class,
            () -> exceptionSample.checkExceptionPublic(times, molJcicRemainsCount));
    // Assert
    assertEquals(
        new ValidException(ExceptionSample.ErrorCode.JCIC_COUNT_EXCEED_THREE_TIMES)
            .getResultErrors()
            .toString(),
        exception.getMessage());
  }

  @Test
  void checkExceptionPrivate() {
    // Arrange
    Integer times = 2;
    Integer molJcicRemainsCount = 1;
    // Act
    ValidException exception =
        (ValidException)
            assertThrows(
                    UndeclaredThrowableException.class,
                    () ->
                        ReflectionTestUtils.invokeMethod(
                            exceptionSample, "checkExceptionPrivate", times, molJcicRemainsCount))
                .getUndeclaredThrowable();
    // Assert
    assertEquals(
        new ValidException(ExceptionSample.ErrorCode.JCIC_COUNT_EXCEED_THREE_TIMES)
            .getResultErrors()
            .toString(),
        exception.getMessage());
  }
}
