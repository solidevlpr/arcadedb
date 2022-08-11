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
/* Generated By:JJTree: Do not edit this line. OTraverseProjectionItem.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.database.Identifiable;
import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.Result;
import com.arcadedb.query.sql.executor.ResultSet;

import java.util.*;

public class TraverseProjectionItem extends SimpleNode {

  protected BaseIdentifier base;
  protected Modifier       modifier;

  public TraverseProjectionItem(int id) {
    super(id);
  }

  public TraverseProjectionItem(SqlParser p, int id) {
    super(p, id);
  }

  public Object execute(Result iCurrentRecord, CommandContext ctx) {
    if (isStar()) {
      return handleStar(iCurrentRecord, ctx);
    }
    Object result = base.execute(iCurrentRecord, ctx);
    if (modifier != null) {
      result = modifier.execute(iCurrentRecord, result, ctx);
    }
    return result;
  }

  private boolean isStar() {
    return base.toString().equals("*") && modifier == null;
  }

  private Object handleStar(Result iCurrentRecord, CommandContext ctx) {
    Set<Object> result = new HashSet<>();
    for (String prop : iCurrentRecord.getPropertyNames()) {
      Object val = iCurrentRecord.getProperty(prop);
      if (isOResult(val) || isValidIdentifiable(val)) {
        result.add(val);

      } else {
        if (val instanceof Iterable) {
          val = ((Iterable) val).iterator();
        }
        if (val instanceof Iterator) {
          while (((Iterator) val).hasNext()) {
            Object sub = ((Iterator) val).next();
            if (isOResult(sub) || isValidIdentifiable(sub)) {
              result.add(sub);
            }
          }
        } else if (val instanceof ResultSet) {
          while (((ResultSet) val).hasNext()) {
            result.add(((ResultSet) val).next());
          }
        }
      }
    }
    return result;
  }

  private boolean isValidIdentifiable(Object val) {
    return val instanceof Identifiable;
  }

  private boolean isOResult(Object val) {
    return val instanceof Result;
  }

  public void toString(Map<String, Object> params, StringBuilder builder) {

    base.toString(params, builder);
    if (modifier != null) {
      modifier.toString(params, builder);
    }
  }

  public TraverseProjectionItem copy() {
    TraverseProjectionItem result = new TraverseProjectionItem(-1);
    result.base = base == null ? null : base.copy();
    result.modifier = modifier == null ? null : modifier.copy();
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    TraverseProjectionItem that = (TraverseProjectionItem) o;

    if (base != null ? !base.equals(that.base) : that.base != null)
      return false;
    return modifier != null ? modifier.equals(that.modifier) : that.modifier == null;
  }

  @Override
  public int hashCode() {
    int result = (base != null ? base.hashCode() : 0);
    result = 31 * result + (modifier != null ? modifier.hashCode() : 0);
    return result;
  }
}
/* JavaCC - OriginalChecksum=0c562254fd4d11266edc0504fd36fc99 (do not edit this line) */
