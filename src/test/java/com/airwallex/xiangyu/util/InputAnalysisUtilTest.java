package com.airwallex.xiangyu.util;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class InputAnalysisUtilTest {

  @Mock
  InputAnalysisUtil util;

  @Test
  public void testIsNumber(){
    util = new InputAnalysisUtil();

    Assert.assertTrue(InputAnalysisUtil.isNumber("+500"));
    Assert.assertTrue(InputAnalysisUtil.isNumber("-500"));
    Assert.assertTrue(InputAnalysisUtil.isNumber("1234"));
    Assert.assertTrue(InputAnalysisUtil.isNumber("1234.1234"));

    Assert.assertFalse(InputAnalysisUtil.isNumber("1234."));
    Assert.assertFalse(InputAnalysisUtil.isNumber(".1234"));
    Assert.assertFalse(InputAnalysisUtil.isNumber("string"));
  }
}
