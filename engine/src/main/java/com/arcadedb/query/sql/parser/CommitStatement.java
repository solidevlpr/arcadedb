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
/* Generated By:JJTree: Do not edit this line. OCommitStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.InternalResultSet;
import com.arcadedb.query.sql.executor.ResultInternal;
import com.arcadedb.query.sql.executor.ResultSet;

import java.util.*;

public class CommitStatement extends SimpleExecStatement {

  protected PInteger        retry;
  protected List<Statement> elseStatements;
  protected Boolean         elseFail;

  public CommitStatement(final int id) {
    super(id);
  }

  public void addElse(final Statement statement) {
    if (elseStatements == null)
      elseStatements = new ArrayList<>();

    this.elseStatements.add(statement);
  }

  @Override
  public ResultSet executeSimple(final CommandContext context) {
    context.getDatabase().commit(); // no RETRY and ELSE here, that case is allowed only for batch scripts;
    final InternalResultSet result = new InternalResultSet();
    final ResultInternal item = new ResultInternal();
    item.setProperty("operation", "commit");
    result.add(item);
    return result;
  }

  @Override
  public void toString(final Map<String, Object> params, final StringBuilder builder) {
    builder.append("COMMIT");
    if (retry != null) {
      builder.append(" RETRY ");
      retry.toString(params, builder);
      if (elseFail != null || elseStatements != null) {
        builder.append(" ELSE ");
      }
      if (elseStatements != null) {
        builder.append("{\n");
        for (Statement stm : elseStatements) {
          stm.toString(params, builder);
          builder.append(";\n");
        }
        builder.append("}");
      }
      if (elseFail != null) {
        if (elseStatements != null) {
          builder.append(" AND");
        }
        if (elseFail) {
          builder.append(" FAIL");
        } else {
          builder.append(" CONTINUE");
        }
      }
    }
  }

  @Override
  public CommitStatement copy() {
    CommitStatement result = new CommitStatement(-1);
    result.retry = retry == null ? null : retry.copy();
    if (this.elseStatements != null) {
      result.elseStatements = new ArrayList<>();
      for (Statement stm : elseStatements) {
        result.elseStatements.add(stm.copy());
      }
    }
    if (elseFail != null) {
      result.elseFail = elseFail;
    }
    return result;
  }

  public PInteger getRetry() {
    return retry;
  }

  public List<Statement> getElseStatements() {
    return elseStatements;
  }

  public Boolean getElseFail() {
    return elseFail;
  }

  @Override
  protected Object[] getIdentityElements() {
    return new Object[] { retry, elseStatements, elseFail };
  }

}
/* JavaCC - OriginalChecksum=eaa0bc8f765fdaa017789953861bc0aa (do not edit this line) */
