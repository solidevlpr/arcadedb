/*
 * Copyright 2021 Arcade Data Ltd
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/* Generated By:JJTree: Do not edit this line. OOrBlock.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.database.Database;
import com.arcadedb.database.Identifiable;
import com.arcadedb.schema.DocumentType;
import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrBlock extends BooleanExpression {
  List<BooleanExpression> subBlocks = new ArrayList<BooleanExpression>();

  public OrBlock(int id) {
    super(id);
  }

  public OrBlock(SqlParser p, int id) {
    super(p, id);
  }

  @Override
  public boolean evaluate(Identifiable currentRecord, CommandContext ctx) {
    if (getSubBlocks() == null) {
      return true;
    }

    for (BooleanExpression block : subBlocks) {
      if (block.evaluate(currentRecord, ctx)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean evaluate(Result currentRecord, CommandContext ctx) {
    if (getSubBlocks() == null) {
      return true;
    }

    for (BooleanExpression block : subBlocks) {
      if (block.evaluate(currentRecord, ctx)) {
        return true;
      }
    }
    return false;
  }

  public boolean evaluate(Object currentRecord, CommandContext ctx) {
    if (currentRecord instanceof Result) {
      return evaluate((Result) currentRecord, ctx);
    } else if (currentRecord instanceof Identifiable) {
      return evaluate((Identifiable) currentRecord, ctx);
    } else if (currentRecord instanceof Map) {
//      ODocument doc = new ODocument();
//      doc.fromMap((Map<String, Object>) currentRecord);
//      return evaluate(doc, ctx);
      throw new UnsupportedOperationException();
    }
    return false;
  }

  public List<BooleanExpression> getSubBlocks() {
    return subBlocks;
  }

  public void setSubBlocks(List<BooleanExpression> subBlocks) {
    this.subBlocks = subBlocks;
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {
    if (subBlocks == null || subBlocks.size() == 0) {
      return;
    }
    // if (subBlocks.size() == 1) {
    // subBlocks.get(0).toString(params, builder);
    // return;
    // }

    boolean first = true;
    for (BooleanExpression expr : subBlocks) {
      if (!first) {
        builder.append(" OR ");
      }
      expr.toString(params, builder);
      first = false;
    }
  }

  @Override
  protected boolean supportsBasicCalculation() {
    for (BooleanExpression expr : subBlocks) {
      if (!expr.supportsBasicCalculation()) {
        return false;
      }
    }
    return true;
  }

  @Override
  protected int getNumberOfExternalCalculations() {
    int result = 0;
    for (BooleanExpression expr : subBlocks) {
      result += expr.getNumberOfExternalCalculations();
    }
    return result;
  }

  @Override
  protected List<Object> getExternalCalculationConditions() {
    List<Object> result = new ArrayList<Object>();
    for (BooleanExpression expr : subBlocks) {
      result.addAll(expr.getExternalCalculationConditions());
    }
    return result;
  }

  public List<BinaryCondition> getIndexedFunctionConditions(DocumentType iSchemaClass, Database database) {
    if (subBlocks == null || subBlocks.size() > 1) {
      return null;
    }
    List<BinaryCondition> result = new ArrayList<BinaryCondition>();
    for (BooleanExpression exp : subBlocks) {
      List<BinaryCondition> sub = exp.getIndexedFunctionConditions(iSchemaClass, database);
      if (sub != null && sub.size() > 0) {
        result.addAll(sub);
      }
    }
    return result.size() == 0 ? null : result;
  }

  public List<AndBlock> flatten() {
    List<AndBlock> result = new ArrayList<AndBlock>();
    for (BooleanExpression sub : subBlocks) {
      List<AndBlock> childFlattened = sub.flatten();
      for (AndBlock child : childFlattened) {
        result.add(child);
      }
    }
    return result;
  }

  @Override
  public boolean needsAliases(Set<String> aliases) {
    for (BooleanExpression expr : subBlocks) {
      if (expr.needsAliases(aliases)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public OrBlock copy() {
    OrBlock result = new OrBlock(-1);
    result.subBlocks = subBlocks.stream().map(x -> x.copy()).collect(Collectors.toList());
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    OrBlock oOrBlock = (OrBlock) o;

    return subBlocks != null ? subBlocks.equals(oOrBlock.subBlocks) : oOrBlock.subBlocks == null;
  }

  @Override
  public int hashCode() {
    return subBlocks != null ? subBlocks.hashCode() : 0;
  }

  @Override
  public boolean isEmpty() {
    if (subBlocks.isEmpty()) {
      return true;
    }
    for (BooleanExpression block : subBlocks) {
      if (!block.isEmpty()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void extractSubQueries(SubQueryCollector collector) {
    for (BooleanExpression block : subBlocks) {
      block.extractSubQueries(collector);
    }
  }

  @Override
  public boolean refersToParent() {
    for (BooleanExpression exp : subBlocks) {
      if (exp != null && exp.refersToParent()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public List<String> getMatchPatternInvolvedAliases() {
    List<String> result = new ArrayList<String>();
    for (BooleanExpression exp : subBlocks) {
      List<String> x = exp.getMatchPatternInvolvedAliases();
      if (x != null) {
        result.addAll(x);
      }
    }
    return result.size() == 0 ? null : result;
  }

  @Override
  public void translateLuceneOperator() {
    subBlocks.forEach(x -> x.translateLuceneOperator());
  }

  @Override
  public boolean isCacheable() {
    for (BooleanExpression block : this.subBlocks) {
      if (!block.isCacheable()) {
        return false;
      }
    }
    return true;
  }

}
/* JavaCC - OriginalChecksum=98d3077303a598705894dbb7bd4e1573 (do not edit this line) */