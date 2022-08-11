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
/* Generated By:JJTree: Do not edit this line. OArrayConcatExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.database.Identifiable;
import com.arcadedb.exception.CommandExecutionException;
import com.arcadedb.query.sql.executor.AggregationContext;
import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.MultiValue;
import com.arcadedb.query.sql.executor.Result;
import com.arcadedb.query.sql.executor.ResultInternal;

import java.util.*;
import java.util.stream.*;

public class ArrayConcatExpression extends SimpleNode {

  List<ArrayConcatExpressionElement> childExpressions = new ArrayList<>();

  public ArrayConcatExpression(int id) {
    super(id);
  }

  public ArrayConcatExpression(SqlParser p, int id) {
    super(p, id);
  }

  public List<ArrayConcatExpressionElement> getChildExpressions() {
    return childExpressions;
  }

  public void setChildExpressions(List<ArrayConcatExpressionElement> childExpressions) {
    this.childExpressions = childExpressions;
  }

  public Object apply(Object left, Object right) {

    if (left == null && right == null) {
      return null;
    }

    if (right == null) {
      if (MultiValue.isMultiValue(left)) {
        return left;
      } else {
        return Collections.singletonList(left);
      }
    }

    if (left == null) {
      if (MultiValue.isMultiValue(right)) {
        return right;
      } else {
        return Collections.singletonList(right);
      }
    }

    List<Object> result = new ArrayList<>();
    if (MultiValue.isMultiValue(left)) {
      Iterator<Object> leftIter = MultiValue.getMultiValueIterator(left);
      while (leftIter.hasNext()) {
        result.add(leftIter.next());
      }
    } else {
      result.add(left);
    }

    if (MultiValue.isMultiValue(right)) {
      Iterator<Object> rightIter = MultiValue.getMultiValueIterator(right);
      while (rightIter.hasNext()) {
        result.add(rightIter.next());
      }
    } else {
      result.add(right);
    }

    return result;
  }

  public Object execute(Identifiable iCurrentRecord, CommandContext ctx) {
    Object result = childExpressions.get(0).execute(iCurrentRecord, ctx);
    for (int i = 1; i < childExpressions.size(); i++) {
      result = apply(result, childExpressions.get(i).execute(iCurrentRecord, ctx));
    }
    return result;
  }

  public Object execute(Result iCurrentRecord, CommandContext ctx) {
    Object result = childExpressions.get(0).execute(iCurrentRecord, ctx);
    for (int i = 1; i < childExpressions.size(); i++) {
      result = apply(result, childExpressions.get(i).execute(iCurrentRecord, ctx));
    }
    return result;
  }

  public boolean isEarlyCalculated() {
    for (ArrayConcatExpressionElement element : childExpressions) {
      if (!element.isEarlyCalculated()) {
        return false;
      }
    }
    return true;
  }

  protected boolean supportsBasicCalculation() {
    for (ArrayConcatExpressionElement expr : this.childExpressions) {
      if (!expr.supportsBasicCalculation()) {
        return false;
      }
    }
    return true;
  }

  public boolean needsAliases(Set<String> aliases) {
    for (ArrayConcatExpressionElement expr : childExpressions) {
      if (expr.needsAliases(aliases)) {
        return true;
      }
    }
    return false;
  }

  public boolean isAggregate() {
    for (ArrayConcatExpressionElement expr : this.childExpressions) {
      if (expr.isAggregate()) {
        return true;
      }
    }
    return false;
  }

  public SimpleNode splitForAggregation(AggregateProjectionSplit aggregateProj) {
    if (isAggregate()) {
      throw new CommandExecutionException("Cannot use aggregate functions in array concatenation");
    } else {
      return this;
    }
  }

  public AggregationContext getAggregationContext(CommandContext ctx) {
    throw new UnsupportedOperationException("array concatenation expressions do not allow plain aggregation");
  }

  public ArrayConcatExpression copy() {
    ArrayConcatExpression result = new ArrayConcatExpression(-1);
    this.childExpressions.forEach(x -> result.childExpressions.add(x.copy()));
    return result;
  }

  public void extractSubQueries(SubQueryCollector collector) {
    for (ArrayConcatExpressionElement expr : this.childExpressions) {
      expr.extractSubQueries(collector);
    }
  }

  public boolean refersToParent() {
    for (ArrayConcatExpressionElement expr : this.childExpressions) {
      if (expr.refersToParent()) {
        return true;
      }
    }
    return false;
  }

  public List<String> getMatchPatternInvolvedAliases() {
    List<String> result = new ArrayList<>();
    for (ArrayConcatExpressionElement exp : childExpressions) {
      List<String> x = exp.getMatchPatternInvolvedAliases();
      if (x != null) {
        result.addAll(x);
      }
    }
    if (result.isEmpty()) {
      return null;
    }
    return result;
  }

  public void toString(Map<String, Object> params, StringBuilder builder) {
    for (int i = 0; i < childExpressions.size(); i++) {
      if (i > 0) {
        builder.append(" || ");
      }
      childExpressions.get(i).toString(params, builder);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    ArrayConcatExpression that = (ArrayConcatExpression) o;

    return childExpressions != null ? childExpressions.equals(that.childExpressions) : that.childExpressions == null;
  }

  @Override
  public int hashCode() {
    return childExpressions != null ? childExpressions.hashCode() : 0;
  }

  public Result serialize() {
    ResultInternal result = new ResultInternal();
    if (childExpressions != null) {
      result.setProperty("childExpressions", childExpressions.stream().map(x -> x.serialize()).collect(Collectors.toList()));
    }
    return result;
  }

  public void deserialize(Result fromResult) {

    if (fromResult.getProperty("childExpressions") != null) {
      List<Result> ser = fromResult.getProperty("childExpressions");
      childExpressions = new ArrayList<>();
      for (Result r : ser) {
        ArrayConcatExpressionElement exp = new ArrayConcatExpressionElement(-1);
        exp.deserialize(r);
        childExpressions.add(exp);
      }
    }
  }

  public boolean isCacheable() {
    for (ArrayConcatExpressionElement exp : childExpressions) {
      if (!exp.isCacheable()) {
        return false;
      }
    }
    return true;
  }
}
/* JavaCC - OriginalChecksum=8d976a02f84460bf21c4304009135345 (do not edit this line) */
