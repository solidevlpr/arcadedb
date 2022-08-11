/*
 * Copyright © 2021-present Arcade Data Ltd (info@arcadedata.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-FileCopyrightText: 2021-present Arcade Data Ltd (info@arcadedata.com)
 * SPDX-License-Identifier: Apache-2.0
 */
/* Generated By:JJTree: Do not edit this line. OFloatingPoint.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.query.sql.executor.Result;
import com.arcadedb.query.sql.executor.ResultInternal;

import java.util.*;

public class FloatingPoint extends PNumber {

  protected int    sign        = 1;
  protected String stringValue = null;
  java.lang.Number finalValue = null;

  public FloatingPoint(int id) {
    super(id);
  }

  public FloatingPoint(SqlParser p, int id) {
    super(p, id);
  }

  @Override
  public java.lang.Number getValue() {
    if (finalValue != null) {
      return finalValue;
    }
    if (stringValue.endsWith("F") || stringValue.endsWith("f")) {
      try {
        finalValue = Float.parseFloat(stringValue.substring(0, stringValue.length() - 1)) * sign;
      } catch (Exception ignore) {
        return null;//TODO NaN?
      }
    } else if (stringValue.endsWith("D") || stringValue.endsWith("d")) {
      try {
        finalValue = Double.parseDouble(stringValue.substring(0, stringValue.length() - 1)) * sign;
      } catch (Exception ignore) {
        return null;//TODO NaN?
      }
    } else {
      try {
        double returnValue = Double.parseDouble(stringValue) * sign;
        if (Math.abs(returnValue) < Float.MAX_VALUE) {
          finalValue = (float) returnValue;
        } else {
          finalValue = returnValue;
        }
      } catch (Exception ignore) {
        return null;//TODO NaN?
      }
    }
    return finalValue;
  }

  public int getSign() {
    return sign;
  }

  public void setSign(int sign) {
    this.sign = sign;
  }

  public String getStringValue() {
    return stringValue;
  }

  public void setStringValue(String stringValue) {
    this.stringValue = stringValue;
  }

  public void toString(Map<String, Object> params, StringBuilder builder) {
    if (sign == -1) {
      builder.append("-");
    }
    builder.append(stringValue);
  }

  @Override
  public FloatingPoint copy() {
    FloatingPoint result = new FloatingPoint(-1);
    result.sign = sign;
    result.stringValue = stringValue;
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    FloatingPoint that = (FloatingPoint) o;

    if (sign != that.sign)
      return false;
    return stringValue != null ? stringValue.equals(that.stringValue) : that.stringValue == null;
  }

  @Override
  public int hashCode() {
    int result = sign;
    result = 31 * result + (stringValue != null ? stringValue.hashCode() : 0);
    return result;
  }

  public Result serialize() {
    ResultInternal result = new ResultInternal();
    result.setProperty("sign", sign);
    result.setProperty("stringValue", stringValue);
    result.setProperty("finalValue", finalValue);
    return result;
  }

  public void deserialize(Result fromResult) {
    sign = fromResult.getProperty("sign");
    stringValue = fromResult.getProperty("stringValue");
    finalValue = fromResult.getProperty("finalValue");
  }
}
/* JavaCC - OriginalChecksum=46acfb589f666717595e28f1b19611ae (do not edit this line) */
